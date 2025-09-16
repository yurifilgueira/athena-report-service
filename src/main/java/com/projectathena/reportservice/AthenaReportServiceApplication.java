package com.projectathena.reportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AthenaReportServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaReportServiceApplication.class, args);
    }

}
