package com.pichincha.backend.test.exception;

public class TransactionsNotFoundException extends RuntimeException {

  public TransactionsNotFoundException(String message) {
    super(message);
  }

}
