package com.projectathena.reportservice.controllers;

import com.projectathena.reportservice.dto.DeveloperMetricInfo;
import com.projectathena.reportservice.dto.requests.ReportRequest;

import com.projectathena.reportservice.services.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping()
    public ResponseEntity<?> generateReport(@RequestBody List<DeveloperMetricInfo> infos) {
        var response = reportService.generateReport(infos);

        return ResponseEntity.ok().body(response);
    }
}