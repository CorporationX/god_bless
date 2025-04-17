package school.faang.we_process_errors_beautifully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
