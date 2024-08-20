package faang.school.godbless.HandlingErrorsGracefully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
