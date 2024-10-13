package school.faang.BJS2_33451;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}