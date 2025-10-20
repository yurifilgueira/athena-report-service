package com.projectathena.reportservice.dto;

import java.util.Arrays;
import java.util.List;

public enum MetricType {

    COMMIT_PER_DEVELOPER,
    LOC_PER_DEVELOPER;

    public static List<MetricType> getAll() {
        return Arrays.asList(values());
    }



}
