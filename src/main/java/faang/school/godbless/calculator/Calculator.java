package faang.school.godbless.calculator;

@FunctionalInterface
public interface Calculator<T,U,R> {
    public R act(T a,U b);
}
