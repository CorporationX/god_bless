package faang.school.godbless.calculator;

@FunctionalInterface
public interface Calculator<T > {
    T calculate (T val1, T val2);
}
