package faang.school.godbless.kxnvg.exception;

@FunctionalInterface
public interface ExceptionHandler<T> {

    T control(Exception e);
}
