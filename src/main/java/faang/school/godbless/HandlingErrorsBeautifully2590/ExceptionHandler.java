package faang.school.godbless.HandlingErrorsBeautifully2590;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
