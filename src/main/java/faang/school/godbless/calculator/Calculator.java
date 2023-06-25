package faang.school.godbless.calculator;

@FunctionalInterface
public interface Calculator<T> {
    T run(T value, T valueTwo);
}
