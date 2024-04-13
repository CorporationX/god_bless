package faang.school.godbless.calculator;

@FunctionalInterface
interface Calculator<T> {
    T calculate(T a, T b);
}
