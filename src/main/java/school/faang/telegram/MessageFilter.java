package school.faang.telegram;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
