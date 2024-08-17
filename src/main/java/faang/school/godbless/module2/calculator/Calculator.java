package faang.school.godbless.module2.calculator;

@FunctionalInterface
public interface Calculator<T> {
    T calc(T first, T second);
}
