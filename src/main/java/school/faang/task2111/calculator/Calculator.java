package school.faang.task2111.calculator;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T a, T b);
}
