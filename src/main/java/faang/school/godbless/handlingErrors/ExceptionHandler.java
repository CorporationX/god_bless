package faang.school.godbless.handlingErrors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handleException(Exception e);
}
