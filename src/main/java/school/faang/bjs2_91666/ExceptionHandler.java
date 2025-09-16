package school.faang.bjs2_91666;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}