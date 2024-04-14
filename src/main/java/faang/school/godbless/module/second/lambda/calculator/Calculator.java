package faang.school.godbless.module.second.lambda.calculator;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T firstArgument, T secondArgument);
}
