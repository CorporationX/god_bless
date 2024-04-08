package faang.school.godbless.lambdas.task_6.model;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}