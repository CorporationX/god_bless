package faang.school.godbless.spam_filters;

@FunctionalInterface
public interface MessageFilter<String> {
    boolean filter(String s);
}
