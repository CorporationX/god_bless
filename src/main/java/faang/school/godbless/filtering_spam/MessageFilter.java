package faang.school.godbless.filtering_spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filters(String message);
}
