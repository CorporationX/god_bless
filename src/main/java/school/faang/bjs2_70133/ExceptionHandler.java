package school.faang.bjs2_70133;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T catchException(Exception ex);
}
