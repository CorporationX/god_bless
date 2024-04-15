package faang.school.godbless.sprint_2.filter_spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}