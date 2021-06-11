package com.pichincha.backend.test.exception;

public class SearchedAccountNotFoundException extends RuntimeException {

  public SearchedAccountNotFoundException(String message) {
    super(message);
  }

}
