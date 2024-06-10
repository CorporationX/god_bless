package faang.school.godbless.kalculator;

@FunctionalInterface
public interface Calculator<T, K, U> {
    U interfaceCalculate(T t, K k);
}
