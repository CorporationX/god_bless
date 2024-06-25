package faang.school.godbless;

@FunctionalInterface
public interface Calculator<T, V, M> {
    M applyCalculate(T firstValue, V secondValue);
}
