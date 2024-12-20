package school.faang.task_46305;

@FunctionalInterface
public interface ExceptionCatch<T, R, E extends Exception> {
    R tryCatch(T t) throws E;
}

