package faang.school.godbless.Calculator;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T obj1, T obj2);
}
