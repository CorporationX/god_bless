package school.faang.secondStream.BJS2_33918;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate(T t1, T t2);
}