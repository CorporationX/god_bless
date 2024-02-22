package faang.school.godbless.calculator;

@FunctionalInterface
public interface Calculator<T> {
    int calc(T x, T y);
}
