package faang.school.godbless.filter.spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
