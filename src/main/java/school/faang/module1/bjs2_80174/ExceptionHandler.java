package school.faang.module1.bjs2_80174;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}