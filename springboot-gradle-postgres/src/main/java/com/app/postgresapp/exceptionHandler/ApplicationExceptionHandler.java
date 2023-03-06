package com.app.postgresapp.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;

import java.net.URI;
import java.util.Optional;



@ControllerAdvice
class ApplicationExceptionHandler implements ProblemHandling {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Problem> handleDemoNotWorkingException() {
        return ResponseEntity.of(
                Optional.of(
                        Problem.builder()
                                .withType(URI.create("https://mytodolistapp.com/probs/cant-move-item-to-list"))
                                .withTitle("The target list is at maximum capacity")
                                .withDetail("The target list 'next-week' is full. It already has 10 items.")
                                .withStatus(Status.NOT_FOUND)
                                .build()
                ));
    }

}