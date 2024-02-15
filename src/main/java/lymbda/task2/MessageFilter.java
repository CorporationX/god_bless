package lymbda.task2;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
