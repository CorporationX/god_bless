package school.faang.stream2.exceptionshandler;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handleException(Exception e);
}
