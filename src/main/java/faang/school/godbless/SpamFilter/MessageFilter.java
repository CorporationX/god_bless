package faang.school.godbless.SpamFilter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
