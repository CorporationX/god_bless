package faang.school.godbless.lambdas.filteringSpam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
