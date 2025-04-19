package bjs2_70203;

public interface ErrorHandler<T> {
    T handle(Exception e);
}
