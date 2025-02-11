package school.faang.task_59590;

@FunctionalInterface
public interface Calculator<T> {
    T operation(T first, T second);
}