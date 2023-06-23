package faang.school.godbless.beautifulErrorLog;
@FunctionalInterface
public interface ExceptionHandler<T> {
    T handleErr(Exception exception);
}
