package faang.school.godbless.lambda.spam_telegram;
@FunctionalInterface
public interface MessageFilter {
    public boolean filter(String word);
}
