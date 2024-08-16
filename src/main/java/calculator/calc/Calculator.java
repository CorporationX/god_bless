package calculator.calc;

@FunctionalInterface
public interface Calculator<T extends Number> {

    T calc(T a, T b);

}
