package school.faang.spring2.task_45701;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate(T type1, T type2);
}
