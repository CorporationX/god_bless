package faang.school.godbless.module.second.lambda.spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
