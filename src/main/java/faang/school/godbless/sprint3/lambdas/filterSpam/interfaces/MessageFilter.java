package faang.school.godbless.sprint3.lambdas.filterSpam.interfaces;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
