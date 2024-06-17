package faang.school.godbless.BJS2_8986;

@FunctionalInterface
public interface Calculator<T, U> {
    U evaluate(T num1, T num2);
}
