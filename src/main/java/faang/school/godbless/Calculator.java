package faang.school.godbless;

@FunctionalInterface
public interface Calculator<T> {

    T calculate(T num, T result);
}
