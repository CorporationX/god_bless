package faang.school.godbless.spamfiltering;

@FunctionalInterface
public interface MessageFilter {

    boolean filter(String message);
}