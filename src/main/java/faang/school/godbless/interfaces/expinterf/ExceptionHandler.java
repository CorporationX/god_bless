package faang.school.godbless.interfaces.expinterf;
@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle (Exception e);
}
