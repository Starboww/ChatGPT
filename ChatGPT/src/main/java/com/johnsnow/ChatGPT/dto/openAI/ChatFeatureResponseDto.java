package com.johnsnow.ChatGPT.dto.openAI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatFeatureResponseDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("object")
    private String object;

    @JsonProperty("created")
    private long created;

    @JsonProperty("model")
    private String model;

    @JsonProperty("usage")
    private Usage usage;

    @JsonProperty("choices")
    private List<Choice> choices;

    public static class Usage {

        @JsonProperty("prompt_tokens")
        private int promptTokens;

        @JsonProperty("completion_tokens")
        private int completionTokens;

        @JsonProperty("total_tokens")
        private int totalTokens;

        // getters and setters
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Choice {

        @JsonProperty("message")
        private Message message;

        @JsonProperty("finish_reason")
        private String finishReason;

        @JsonProperty("index")
        private int index;

        // getters and setters
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Message {

        @JsonProperty("role")
        private String role;

        @JsonProperty("content")
        private String content;

        // getters and setters
    }

    // getters and setters
}
