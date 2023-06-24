package sprint3.lambda.spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
