package school.faang.bjs2_80164;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
