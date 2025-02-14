package school.faang.task_60208;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}