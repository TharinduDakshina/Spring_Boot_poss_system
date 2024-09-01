package com.example.SpringBoot_revition.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundExecution extends RuntimeException{
    public NotFoundExecution(String massage){
        super(massage);
    }
}
