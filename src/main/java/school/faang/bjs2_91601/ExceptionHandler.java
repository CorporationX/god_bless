package school.faang.bjs2_91601;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
