package faang.school.godbless.lambdas6;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
