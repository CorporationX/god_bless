package faang.school.godbless.Calculator.function;

@FunctionalInterface
public interface Calculator<T> {
    T add(T a, T b);
}