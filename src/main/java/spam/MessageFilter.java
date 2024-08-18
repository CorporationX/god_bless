package spam;

@FunctionalInterface
public interface MessageFilter<T> {
    boolean filter(T message);
}
