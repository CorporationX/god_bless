package school.faang.sprint_2.spam_filter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
