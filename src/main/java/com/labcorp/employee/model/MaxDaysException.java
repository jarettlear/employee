package com.labcorp.employee.model;

import lombok.AllArgsConstructor;

public class MaxDaysException extends Exception {

    public MaxDaysException(String errorMessage) {
        super(errorMessage);
    }

}
