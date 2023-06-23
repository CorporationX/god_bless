package faang.school.godbless;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
