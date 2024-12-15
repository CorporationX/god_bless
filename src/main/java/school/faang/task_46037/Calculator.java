package school.faang.task_46037;

@FunctionalInterface
public interface Calculator<T> {
    T operation(T first, T second);
}