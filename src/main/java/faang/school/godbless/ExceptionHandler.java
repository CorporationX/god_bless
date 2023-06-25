package faang.school.godbless;
@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception ex);
}
