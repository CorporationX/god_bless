package faang.school.godbless.HandleErrors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
