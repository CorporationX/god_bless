package faang.school.godbless.spamfilter;

@FunctionalInterface
public interface MessageFilter {
    public boolean filter(String message);
}
