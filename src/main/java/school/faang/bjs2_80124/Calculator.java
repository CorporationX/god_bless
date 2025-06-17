package school.faang.bjs2_80124;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate(T a, T b);
}
