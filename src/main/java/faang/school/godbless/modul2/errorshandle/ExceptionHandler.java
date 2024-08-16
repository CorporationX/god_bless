package faang.school.godbless.modul2.errorshandle;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
