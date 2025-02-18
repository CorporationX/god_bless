package school.faang.BJS2_57152;

@FunctionalInterface
public interface Calculator<T> {
    T operation(T firstNum, T secondNum);
}
