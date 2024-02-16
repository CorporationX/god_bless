package faang.school.godbless.spam_filter;

@FunctionalInterface
public interface MessageFilter {
     boolean filter(String message);
}
