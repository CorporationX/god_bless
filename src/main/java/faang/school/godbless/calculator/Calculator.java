package faang.school.godbless.calculator;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate(T firstParam, T secondParam);
}
