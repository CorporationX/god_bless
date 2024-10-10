package school.faang.BJS2_33441_HandlingErrorsBeautifully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
