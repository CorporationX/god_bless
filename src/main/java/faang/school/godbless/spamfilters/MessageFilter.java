package faang.school.godbless.spamfilters;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
