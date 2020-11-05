package com.thoughtworks.capacity.gtb.mvc.utils;

import com.thoughtworks.capacity.gtb.mvc.entity.ErrorResult;
import com.thoughtworks.capacity.gtb.mvc.exception.LoginErrorException;
import com.thoughtworks.capacity.gtb.mvc.exception.NameAlreadyExitException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex){
        String message=ex.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResult errorResult=new ErrorResult(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(NameAlreadyExitException.class)
    public ResponseEntity<ErrorResult> handle(NameAlreadyExitException ex){
        String message="名字已经存在";
        ErrorResult errorResult=new ErrorResult(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(LoginErrorException.class)
    public ResponseEntity<ErrorResult> handle(LoginErrorException ex){
        String message="用户名或密码错误";
        ErrorResult errorResult=new ErrorResult(message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }
}
