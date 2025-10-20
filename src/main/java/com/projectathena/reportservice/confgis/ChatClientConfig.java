package com.projectathena.reportservice.confgis;

import io.modelcontextprotocol.client.McpSyncClient;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder, ChatMemory  chatMemory, List<McpSyncClient> mcpClients) {
        var systemPrompt = """
        You are an expert Analyst and technical writer specializing in software developer performance reviews.
        Your primary function is to transform raw developer metrics into a professional, well-structured, and insightful performance report.
        
        Instructions:
        1.  Tone: Maintain a formal, objective, and constructive tone throughout the report.
        2.  Structure: The report must include three distinct sections: an 'Executive Summary' of overall performance, an 'Key Achievements' section detailing strengths and accomplishments based on the data, and a 'Growth Opportunities' section with actionable suggestions for improvement.
        3.  Content: Do not simply list the metrics. Interpret them to build a professional narrative about the developer's contributions and performance during the period.
        4.  Constraint: You must base the report STRICTLY on the data provided. Do not invent, assume, or extrapolate information not present in the user's prompt.
        5.  Constraint: You must write in PT-BR and format in markdown.
        """;
        return chatClientBuilder
                .defaultSystem(systemPrompt)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultToolCallbacks(new SyncMcpToolCallbackProvider(mcpClients))
                .build();
    }

}