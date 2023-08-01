package com.johnsnow.ChatGPT.service.impl;

import com.johnsnow.ChatGPT.dto.chat.BasicChatRequestDto;
import com.johnsnow.ChatGPT.dto.chat.BasicChatResponseDto;
import com.johnsnow.ChatGPT.dto.openAI.ChatFeatureResponseDto;
import com.johnsnow.ChatGPT.libs.InternalServerErrorException;
import com.johnsnow.ChatGPT.service.BasicChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Slf4j
public class BasicChatServiceImpl implements BasicChatService {
    @Override
    public BasicChatResponseDto basicChat(BasicChatRequestDto basicChatRequestDto) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(""); // TODO: replace with actual API key

        Map<String, Object> requestBody = new HashMap<>();
        List<BasicChatRequestDto.Message> messagesList = new ArrayList<>(basicChatRequestDto.getMessages());
        requestBody.put("messages", messagesList);
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("temperature", 0.5);
        requestBody.put("max_tokens", 1000);
        requestBody.put("n", 1);

        log.info(requestBody.toString());
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        ChatFeatureResponseDto responseDto;
        try {
            ResponseEntity<ChatFeatureResponseDto> response = restTemplate.postForEntity(
                    "https://api.openai.com/v1/chat/completions", request, ChatFeatureResponseDto.class);
            responseDto = response.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            // handle HTTP error (e.g. 401 Unauthorized, 500 Internal Server Error)
            log.error("Error calling API: {}", e.getMessage());
            throw e;
        } catch (RestClientException e) {
            // handle general REST client error (e.g. connection refused, timeout)
            log.error("Error calling API: {}", e.getMessage());
            throw new InternalServerErrorException("Error calling API", e);
        }

        if (responseDto == null || responseDto.getChoices() == null || responseDto.getChoices().isEmpty()) {
            log.warn("API response is empty");
            return null; // or throw an exception, depending on your requirements
        }

        BasicChatResponseDto.Message message = new BasicChatResponseDto.Message();
        ChatFeatureResponseDto.Choice choice = responseDto.getChoices().get(0);
        message.setRole(choice.getMessage().getRole()); // set the role to "bot" since this is a response from the API
        message.setContent(choice.getMessage().getContent()); // set the content to the text of the message in the Choice object

        return BasicChatResponseDto.builder()
                .message(message)
                .build();


    }
}
