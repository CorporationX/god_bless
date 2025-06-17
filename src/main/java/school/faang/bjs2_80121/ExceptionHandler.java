package school.faang.bjs2_80121;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}