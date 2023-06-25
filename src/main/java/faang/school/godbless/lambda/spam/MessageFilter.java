package faang.school.godbless.lambda.spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String str);
}
