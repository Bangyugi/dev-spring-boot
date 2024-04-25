package com.bangvan.buoi3demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler
    public ErrorResponse handlerNotFoundException(NotFound notFound, WebRequest request){
        return new ErrorResponse(notFound.getResponse(), notFound.getStatus());
    }
}
