package school.faang.calculator;

@FunctionalInterface
public interface Calculator<T, U, R> {
    R calculate(T t, U u);
}
