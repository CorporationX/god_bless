package school.faang.handling_errors_beautifully_bjs2_80131;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
