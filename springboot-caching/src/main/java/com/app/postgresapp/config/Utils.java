package com.app.postgresapp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.jackson.ProblemModule;

@Configuration
public class Utils {

    @Bean
    public ObjectMapper mapper() {

        return new ObjectMapper()
                .registerModule(new ProblemModule().withStackTraces());
    }
}
