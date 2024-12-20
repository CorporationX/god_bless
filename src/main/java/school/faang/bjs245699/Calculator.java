package school.faang.bjs245699;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T x, T y);
}