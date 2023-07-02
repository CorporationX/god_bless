package faang.school.godbless.lambda.task12_filterSpam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
