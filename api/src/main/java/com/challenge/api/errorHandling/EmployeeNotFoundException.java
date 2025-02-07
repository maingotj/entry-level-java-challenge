package com.challenge.api.errorHandling;

import java.util.UUID;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(UUID uuid) {
        super("Could not find employee " + uuid);
    }
}
