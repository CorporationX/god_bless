package faang.school.godbless.proccess_btfly;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T processException(Exception exception);
}
