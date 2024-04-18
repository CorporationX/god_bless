package faang.school.godbless.handlingErrorsGracefully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}