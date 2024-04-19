package faang.school.godbless.calculators;


@FunctionalInterface
public interface Calculator<T> {
    T calculate(T a, T b);
}