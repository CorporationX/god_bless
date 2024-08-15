package faang.school.godbless.calculus;

@FunctionalInterface
public interface Calculator<T> {
    T compute(T a, T b);
}
