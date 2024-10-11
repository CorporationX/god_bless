package school.faang.FilteringSpam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
