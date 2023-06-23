package faang.school.godbless.sprint3.errorHandler.interfaces;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handling(Exception e);
}
