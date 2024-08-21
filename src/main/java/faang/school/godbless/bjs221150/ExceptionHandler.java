package faang.school.godbless.bjs221150;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}