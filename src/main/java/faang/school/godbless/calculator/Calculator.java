package faang.school.godbless.calculator;

@FunctionalInterface
public interface Calculator<T> {
    public T calculation(T valueFirst, T valueSecond);
}
