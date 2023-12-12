package faang.school.godbless.spamFilter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
