package faang.school.godbless.sprint_2.task_46273;

@FunctionalInterface
public interface ThrowableSupplier<T, E extends Exception> {
    T get() throws E;
}
