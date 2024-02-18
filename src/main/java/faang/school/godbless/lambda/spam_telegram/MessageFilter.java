package faang.school.godbless.lambda.spam_telegram;
@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
