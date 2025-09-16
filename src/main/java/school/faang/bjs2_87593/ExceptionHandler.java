package school.faang.bjs2_87593;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T manageException(Exception e);
}