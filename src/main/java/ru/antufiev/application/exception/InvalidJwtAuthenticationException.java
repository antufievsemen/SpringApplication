package ru.antufiev.application.exception;

public class InvalidJwtAuthenticationException extends RuntimeException{

  public InvalidJwtAuthenticationException(String message) {
    super(message);
  }
}
