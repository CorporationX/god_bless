package faang.school.godbless.FilteringSpam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
