package com.projectathena.reportservice.controllers;

import com.projectathena.reportservice.dto.DeveloperMetricInfoInput;

import com.projectathena.reportservice.dto.responses.ReportResponse;
import com.projectathena.reportservice.services.ReportService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @QueryMapping
    public ReportResponse generateReport(@Argument List<DeveloperMetricInfoInput> infos) {

        System.out.println("Arroz: " + infos.getFirst().getMetricValues().getFirst());

        return reportService.generateReport(infos);
    }
}