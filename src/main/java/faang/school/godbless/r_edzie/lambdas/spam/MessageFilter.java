package faang.school.godbless.r_edzie.lambdas.spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
