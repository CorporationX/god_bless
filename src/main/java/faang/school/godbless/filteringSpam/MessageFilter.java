package faang.school.godbless.filteringSpam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
