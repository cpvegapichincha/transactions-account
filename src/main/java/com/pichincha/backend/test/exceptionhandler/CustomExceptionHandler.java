package com.pichincha.backend.test.exceptionhandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.pichincha.backend.test.exception.SearchedAccountNotFoundException;
import com.pichincha.backend.test.exception.TransactionsNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler({SearchedAccountNotFoundException.class, TransactionsNotFoundException.class})
  protected ResponseEntity<Object> handleNotFoundExceptions(
      Exception exception) {
    return new ResponseEntity<>(NOT_FOUND);
  }
}
