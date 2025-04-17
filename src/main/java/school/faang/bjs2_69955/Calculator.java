package school.faang.bjs2_69955;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate(T firstValue, T secondValue);
}