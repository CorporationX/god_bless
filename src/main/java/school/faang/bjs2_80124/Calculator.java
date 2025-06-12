package school.faang.bjs2_80124;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate(T v1, T v2);
}
