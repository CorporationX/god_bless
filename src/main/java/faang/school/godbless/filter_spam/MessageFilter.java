package faang.school.godbless.filter_spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}