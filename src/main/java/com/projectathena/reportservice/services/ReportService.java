package com.projectathena.reportservice.services;

import com.projectathena.reportservice.dto.DeveloperMetricInfoInput;
import com.projectathena.reportservice.dto.responses.ReportResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.stream.Collectors;

@Service
@SessionScope
public class ReportService {

    private final ChatClient chatClient;

    public ReportService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public ReportResponse generateReport(List<DeveloperMetricInfoInput> infos) {


        String metricsData = infos.stream()
                .map(DeveloperMetricInfoInput::toString)
                .collect(Collectors.joining("\n--------------------------------\n"));

        String finalPrompt = """
            Here is a list of performance metrics for multiple developers.
            Please generate a single, consolidated performance report based on this data.
            The report should provide a comparative analysis, highlighting top performers and identifying common trends or challenges across the team.

            **Metrics Data:**
            %s
            """.formatted(metricsData);

        String report = chatClient.prompt()
                .user(userMessage -> userMessage.text(finalPrompt))
                .call()
                .content();

        return new ReportResponse(report);
    }
}