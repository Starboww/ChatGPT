package com.johnsnow.ChatGPT.dto.openAI;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatFeatureRequestDto {

    @JsonProperty("messages")
    private List<Message> messages;

    @JsonProperty("model")
    private String model;

    @JsonProperty("temperature")
    private Double temperature;

    @JsonProperty("max_tokens")
    private Integer maxTokens;

    @JsonProperty("n")
    private Integer n;

    @JsonProperty("stop")
    private String stop;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Message {
        @JsonProperty("role")
        private String role;

        @JsonProperty("content")
        private String content;
    }

}
