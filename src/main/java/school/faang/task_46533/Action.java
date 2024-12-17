package school.faang.task_46533;

@FunctionalInterface
public interface Action<T> {
    T act() throws Exception;
}
