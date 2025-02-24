package school.faang.errorhandle;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
