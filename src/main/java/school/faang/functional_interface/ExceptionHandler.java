package school.faang.functional_interface;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
