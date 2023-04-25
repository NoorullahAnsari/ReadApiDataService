package com.noor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.noor.service.ApiEntryService;

@SpringBootApplication
public class RestApiDemoApplication implements CommandLineRunner {
    private final ApiEntryService apiEntryService;

    @Autowired
    public RestApiDemoApplication(ApiEntryService apiEntryService) {
        this.apiEntryService = apiEntryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestApiDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        apiEntryService.saveApiEntriesFromApi();
    }
}
