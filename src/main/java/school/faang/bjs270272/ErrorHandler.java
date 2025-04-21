package school.faang.bjs270272;

public interface ErrorHandler<T> {
    T handle(Exception e);
}

