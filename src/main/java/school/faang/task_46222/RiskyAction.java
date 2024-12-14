package school.faang.task_46222;

@FunctionalInterface
public interface RiskyAction<T, V, E extends Throwable> {
    T call(V param) throws E;
}
