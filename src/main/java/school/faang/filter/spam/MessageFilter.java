package school.faang.filter.spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
