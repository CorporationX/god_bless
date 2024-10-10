package faang.school.godbless.MessageProcessor;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
