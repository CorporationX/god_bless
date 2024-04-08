package spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
