package school.faang.bjs2_70194;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}