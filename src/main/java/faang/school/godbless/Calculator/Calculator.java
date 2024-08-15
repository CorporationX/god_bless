package faang.school.godbless.Calculator;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T a, T b);
}
