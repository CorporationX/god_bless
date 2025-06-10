package school.faang.bjs2_80121;

public interface ExceptionHandler<T> {
    T handler(Exception e);
}