package school.faang.bjs245708;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T a, T b);
}
