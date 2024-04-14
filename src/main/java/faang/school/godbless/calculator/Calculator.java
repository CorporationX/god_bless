package faang.school.godbless.calculator;

@FunctionalInterface
public interface Calculator<T> {
    T calc(T firsNumber, T secondNumber);
}
