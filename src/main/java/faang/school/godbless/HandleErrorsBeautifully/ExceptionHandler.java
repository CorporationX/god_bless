package faang.school.godbless.HandleErrorsBeautifully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T warn(Exception e);
}
