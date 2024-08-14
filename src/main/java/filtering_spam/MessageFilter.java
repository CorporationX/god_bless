package filtering_spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
