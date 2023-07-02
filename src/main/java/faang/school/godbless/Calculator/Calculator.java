package faang.school.godbless.Calculator;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T function(T a, T b);
}
