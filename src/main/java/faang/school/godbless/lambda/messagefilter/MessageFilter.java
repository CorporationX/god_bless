package faang.school.godbless.lambda.messagefilter;

@FunctionalInterface
public interface MessageFilter {

    boolean filter(String message);
}
