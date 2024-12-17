package school.faang.sprint_2.task_46310;

@FunctionalInterface
public interface Action<T> {
    T execute() throws Exception;
}