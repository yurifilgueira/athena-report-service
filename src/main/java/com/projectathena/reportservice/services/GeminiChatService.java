package com.projectathena.reportservice.services;

import com.projectathena.reportservice.dto.PromptRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

@Service
@SessionScope
public class GeminiChatService implements ChatService {

    private final ChatClient chatClient;

    public GeminiChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public String getAnswer(PromptRequest prompt) {
        return chatClient.prompt()
                .user(userMessage -> userMessage.text(prompt.prompt()))
                .call()
                .content();
    }
}