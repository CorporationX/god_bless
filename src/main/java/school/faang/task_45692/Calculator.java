package school.faang.task_45692;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate(T t1, T t2);
}
