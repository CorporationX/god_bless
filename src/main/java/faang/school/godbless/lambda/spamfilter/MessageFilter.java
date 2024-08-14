package faang.school.godbless.lambda.spamfilter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
