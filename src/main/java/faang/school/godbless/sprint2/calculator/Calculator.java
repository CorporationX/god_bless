package faang.school.godbless.sprint2.calculator;

@FunctionalInterface
public interface Calculator<T> {

    T compute(T first, T second);
}
