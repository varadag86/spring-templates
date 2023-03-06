package com.app.postgresapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Base Application",
                version = "1.0.0",
                description = "Simple Gradle Application",
                license = @License(
                        name = "opensource users",
                        url = "user@user.com"
                )
        )
)
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

}
