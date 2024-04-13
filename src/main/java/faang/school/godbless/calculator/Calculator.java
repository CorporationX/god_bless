package faang.school.godbless.calculator;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T a, T b);
}