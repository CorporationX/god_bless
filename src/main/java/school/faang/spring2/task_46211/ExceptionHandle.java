package school.faang.spring2.task_46211;

@FunctionalInterface
public interface ExceptionHandle<T> {
    T handle(Exception e);
}
