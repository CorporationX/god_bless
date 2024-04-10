package calculator;

@FunctionalInterface
public interface Calculator<T> {

    public T calc(T firstParameter, T secondParameter);
}
