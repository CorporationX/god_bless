package school.faang.handle_errors_BJS2_33421;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception E);
}
