package school.faang.bjs2_80091;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
