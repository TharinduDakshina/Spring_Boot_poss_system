package com.example.SpringBoot_revition.advisor;

import com.example.SpringBoot_revition.exception.NotFoundExecution;
import com.example.SpringBoot_revition.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(NotFoundExecution.class)
    public ResponseEntity handleNotFoundException(NotFoundExecution e){
        return new ResponseEntity(new StandardResponse(404,"Error",e.getMessage()), HttpStatus.NOT_FOUND);
    }

}
