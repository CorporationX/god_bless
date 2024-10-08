package org.example.model.handleError;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T catchHandler(Exception e);
}
