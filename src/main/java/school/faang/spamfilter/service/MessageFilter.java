package school.faang.spamfilter.service;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}