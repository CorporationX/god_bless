package faang.school.godbless.r_edzie.spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
