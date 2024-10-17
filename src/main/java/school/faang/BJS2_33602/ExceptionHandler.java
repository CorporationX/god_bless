package school.faang.BJS2_33602;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
