package faang.school.godbless.lambda;

@FunctionalInterface
public interface MessageFilter {

    boolean filter(String message);
}
