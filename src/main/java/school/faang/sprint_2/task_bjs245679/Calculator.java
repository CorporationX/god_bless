package school.faang.sprint_2.task_bjs245679;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate(T a, T b);
}
