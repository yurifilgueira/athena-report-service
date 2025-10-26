package com.projectathena.reportservice.dto;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class MetricValueInput implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private BigDecimal value;
    private String description;
    private MetricType metricType;

    public MetricValueInput() {
    }

    public MetricValueInput(BigDecimal value, String description, MetricType metricType) {
        this.value = value;
        this.description = description;
        this.metricType = metricType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MetricType getMetricType() {
        return metricType;
    }

    public void setMetricType(MetricType metricType) {
        this.metricType = metricType;
    }

    @Override
    public String toString() {
        return "MetricValueInput{" +
                "value=" + value +
                ", description='" + description + '\'' +
                ", metricType=" + metricType +
                '}';
    }
}
