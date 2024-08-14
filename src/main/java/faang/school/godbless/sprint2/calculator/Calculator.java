package faang.school.godbless.sprint2.calculator;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T t1, T t2);
}
