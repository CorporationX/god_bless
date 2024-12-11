package school.faang.task_46222;

@FunctionalInterface
public interface RiskyAction<T, E extends Throwable> {
    T call() throws E;
}
