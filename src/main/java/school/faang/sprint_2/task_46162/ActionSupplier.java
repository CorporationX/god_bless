package school.faang.sprint_2.task_46162;

@FunctionalInterface
public interface ActionSupplier<T> {
    T get() throws Exception;
}
