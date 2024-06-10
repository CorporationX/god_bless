package faang.school.godbless.func.errors;

@FunctionalInterface
public interface ExceptionHandler<T> {

    T handle(Exception exception);
}
