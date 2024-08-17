package faang.school.godbless.lambda.calculator;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate(T first, T second);
}
