package faang.school.godbless.calculator;

@FunctionalInterface
public interface Calculator<T> {
    int action(T a, T b);
}
