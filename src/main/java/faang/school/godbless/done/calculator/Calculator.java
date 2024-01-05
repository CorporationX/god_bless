package faang.school.godbless.done.calculator;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T apply (T a, T b);
}
