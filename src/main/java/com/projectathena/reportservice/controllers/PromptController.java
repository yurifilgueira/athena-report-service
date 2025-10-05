package com.projectathena.reportservice.controllers;

import com.projectathena.reportservice.dto.PromptRequest;
import com.projectathena.reportservice.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/chat")
public class PromptController {

    private final ChatService chatService;

    @Autowired
    public PromptController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping()
    public String prompt(@RequestBody PromptRequest prompt) {
        return chatService.getAnswer(prompt);
    }
}