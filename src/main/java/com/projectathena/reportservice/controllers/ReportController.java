package com.projectathena.reportservice.controllers;

import com.projectathena.reportservice.dto.DeveloperMetricInfo;
import com.projectathena.reportservice.dto.requests.ReportRequest;

import com.projectathena.reportservice.dto.responses.ReportResponse;
import com.projectathena.reportservice.services.ReportService;
import jakarta.ws.rs.POST;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ReportResponse> generateReport(@RequestBody List<DeveloperMetricInfo> infos) {
        return reportService.generateReport(infos);
    }

}