package faang.school.godbless.spamFilters;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
