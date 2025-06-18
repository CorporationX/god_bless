package school.faang.sprint1_2.bjs2_80124;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate(T a, T b);
}
