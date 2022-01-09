package com.example.annuaire.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PersonConflictException extends RuntimeException{
    public PersonConflictException(String message) {
        super(message);
    }
}
