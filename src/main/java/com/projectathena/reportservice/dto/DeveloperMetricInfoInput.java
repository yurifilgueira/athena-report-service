package com.projectathena.reportservice.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DeveloperMetricInfoInput {

    private String developerUsername;
    private String developerEmail;
    private List<MetricValueInput> metricValues;

    public DeveloperMetricInfoInput() {
    }

    public DeveloperMetricInfoInput(List<MetricValueInput> metricValues, String developerEmail, String developerUsername) {
        this.metricValues = metricValues;
        this.developerEmail = developerEmail;
        this.developerUsername = developerUsername;
    }

    public String getDeveloperUsername() {
        return developerUsername;
    }

    public void setDeveloperUsername(String developerUsername) {
        this.developerUsername = developerUsername;
    }

    public String getDeveloperEmail() {
        return developerEmail;
    }

    public void setDeveloperEmail(String developerEmail) {
        this.developerEmail = developerEmail;
    }

    public List<MetricValueInput> getMetricValues() {
        return metricValues;
    }

    public void setMetricValues(List<MetricValueInput> metricValues) {
        this.metricValues = metricValues;
    }

    @Override
    public String toString() {
        return "DeveloperMetricInfoInput{" +
                "developerUsername='" + developerUsername + '\'' +
                ", developerEmail='" + developerEmail + '\'' +
                ", metricValues=" + metricValues +
                '}';
    }
}
