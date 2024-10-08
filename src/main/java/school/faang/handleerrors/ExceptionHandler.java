package school.faang.handleerrors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle() throws Exception;
}