package faang.school.godbless.calculator.interfaces;

@FunctionalInterface
public interface Calculator<T> {
    T apply(T param1, T param2);
}
