package school.faang.sprint2.task_bjs246255;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
