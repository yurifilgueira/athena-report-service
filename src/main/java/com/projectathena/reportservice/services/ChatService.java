package com.projectathena.reportservice.services;

import com.projectathena.reportservice.dto.PromptRequest;

public interface ChatService {

    String getAnswer(PromptRequest prompt);

}
