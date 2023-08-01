package com.johnsnow.ChatGPT.service;

import com.johnsnow.ChatGPT.dto.chat.BasicChatRequestDto;
import com.johnsnow.ChatGPT.dto.chat.BasicChatResponseDto;

public interface BasicChatService {
 BasicChatResponseDto basicChat(BasicChatRequestDto basicChatRequestDto);
}
