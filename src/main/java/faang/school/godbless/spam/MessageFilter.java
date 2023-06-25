package faang.school.godbless.spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String text);
}
