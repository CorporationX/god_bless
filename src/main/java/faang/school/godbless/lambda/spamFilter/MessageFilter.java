package faang.school.godbless.lambda.spamFilter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
