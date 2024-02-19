package faang.school.godbless.r_edzie.lambdas.calc;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T firstValue, T secondValue);
}
