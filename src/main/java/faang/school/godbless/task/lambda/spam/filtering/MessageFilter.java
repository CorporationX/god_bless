package faang.school.godbless.task.lambda.spam.filtering;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
