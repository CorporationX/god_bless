package faang.school.godbless.lambdas.spamfiltering;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
