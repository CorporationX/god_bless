package school.faang.calculator;

@FunctionalInterface
public interface Calculator<T> {
    Integer calculate(Integer a, Integer b);
}
