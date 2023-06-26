package faang.school.godbless.lambda.filteringSpam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
