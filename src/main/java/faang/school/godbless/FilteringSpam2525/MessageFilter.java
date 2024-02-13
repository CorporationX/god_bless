package faang.school.godbless.FilteringSpam2525;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
