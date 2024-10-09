package org.example.model.handleError;

public interface HandledErrorSupplier<T> {
    T get() throws Exception;
}
