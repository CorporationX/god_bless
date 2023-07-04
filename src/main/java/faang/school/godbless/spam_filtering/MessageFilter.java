package faang.school.godbless.spam_filtering;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
