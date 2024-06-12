package faang.school.godbless.spamfilter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
