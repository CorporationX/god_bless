package spamFiltering;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
