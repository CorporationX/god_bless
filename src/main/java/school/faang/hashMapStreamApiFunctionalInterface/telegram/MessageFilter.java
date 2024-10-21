package school.faang.hashMapStreamApiFunctionalInterface.telegram;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
