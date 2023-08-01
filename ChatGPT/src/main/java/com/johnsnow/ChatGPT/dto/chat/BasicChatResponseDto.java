package com.johnsnow.ChatGPT.dto.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasicChatResponseDto {
    
    @JsonProperty("message")
    private Message message;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Message {

        @JsonProperty("role")
        private String role;

        @JsonProperty("content")
        private String content;

        // getters and setters
    }
}
