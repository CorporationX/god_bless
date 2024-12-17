package school.faang.bjs246477;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
