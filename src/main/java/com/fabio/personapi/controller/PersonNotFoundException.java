package com.fabio.personapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends IOException {

    public PersonNotFoundException(String message) {
        super(message);
    }
}
