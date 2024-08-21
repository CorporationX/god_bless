package BJS2_21124_ProccessingErrors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handleException(Exception e);
}
