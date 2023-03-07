package com.app.postgresapp.exceptionHandler;


import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class DataNotFoundException extends AbstractThrowableProblem {

    public DataNotFoundException(String message, Long key) {
        super(
                null,
                message,
                Status.NOT_FOUND,
                String.format("key: %d is not found", key)
        );
    }
}
