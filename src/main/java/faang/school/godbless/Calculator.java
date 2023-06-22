package faang.school.godbless;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T a, T b);
}
