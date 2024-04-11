package SpamFilter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
