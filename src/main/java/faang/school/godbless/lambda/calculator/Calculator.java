package faang.school.godbless.lambda.calculator;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T a, T b);
}
