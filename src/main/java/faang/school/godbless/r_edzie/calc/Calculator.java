package faang.school.godbless.r_edzie.calc;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T firstValue, T secondValue);
}
