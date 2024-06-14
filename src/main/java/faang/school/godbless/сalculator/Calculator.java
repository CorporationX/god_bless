package faang.school.godbless.сalculator;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T a, T b);
}
