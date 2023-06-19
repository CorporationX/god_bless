package faang.school.godbless.Calculator.function;

@FunctionalInterface
public interface Calculator<T, N> {
    N add(T a, T b);
}