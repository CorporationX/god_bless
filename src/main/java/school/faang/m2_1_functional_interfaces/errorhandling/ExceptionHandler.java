package school.faang.m2_1_functional_interfaces.errorhandling;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
