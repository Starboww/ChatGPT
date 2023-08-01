package com.johnsnow.ChatGPT.Controller;

import com.johnsnow.ChatGPT.dto.chat.BasicChatRequestDto;
import com.johnsnow.ChatGPT.dto.chat.BasicChatResponseDto;
import com.johnsnow.ChatGPT.libs.ApiResponse;
import com.johnsnow.ChatGPT.libs.ApiResult;
import com.johnsnow.ChatGPT.service.BasicChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1")
public class ChatController {
    @Autowired
    BasicChatService basicChatService;
    @PostMapping(path = "/basic-chat")
    ResponseEntity<ApiResponse<BasicChatResponseDto>> basicChat(@RequestBody BasicChatRequestDto basicChatRequestDto){
        ApiResponse<BasicChatResponseDto> response = new ApiResponse<>();
        try {

        response.setResult(ApiResult.SUCCESS);
        response.setData(basicChatService.basicChat(basicChatRequestDto));

    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
        return ResponseEntity.ok(response);
    }

}
