package faang.school.godbless.exeptions;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
