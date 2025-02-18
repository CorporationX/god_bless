package school.faang.spamfilter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}