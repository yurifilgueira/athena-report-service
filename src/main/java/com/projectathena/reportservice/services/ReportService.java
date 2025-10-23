package com.projectathena.reportservice.services;

import com.projectathena.reportservice.dto.DeveloperMetricInfo;
import com.projectathena.reportservice.dto.requests.ReportRequest;
import com.projectathena.reportservice.dto.responses.ReportResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
@SessionScope
public class ReportService {

    private final ChatClient chatClient;

    public ReportService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public Flux<String> generateReport(List<DeveloperMetricInfo> infos) {

        String metricsData = infos.stream()
                .map(DeveloperMetricInfo::toString)
                .collect(Collectors.joining("\n--------------------------------\n"));

        String finalPrompt = """
            Here is a list of performance metrics for multiple developers.
            Please generate a single, consolidated performance report based on this data.
            The report should provide a comparative analysis, highlighting top performers and identifying common trends or challenges across the team.

            **Metrics Data:**
            %s
            """.formatted(metricsData);

        return chatClient.
                prompt()
                .user(userMessage -> userMessage.text(finalPrompt))
                .stream()
                .content();
    }

    public Flux<String> hello(String infos) {

        String finalPrompt = """
            Here is a list of performance metrics for multiple developers.
            Please generate a single, consolidated performance report based on this data.
            The report should provide a comparative analysis, highlighting top performers and identifying common trends or challenges across the team.

            **Metrics Data:**
            %s
            """.formatted(infos);

        return chatClient.
                prompt()
                .user(userMessage -> userMessage.text(finalPrompt))
                .stream()
                .content();
    }
}