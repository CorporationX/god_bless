package faang.school.godbless.sprint3.spam;

@FunctionalInterface
public interface MessageFilter {

    boolean filter(String message);
}
