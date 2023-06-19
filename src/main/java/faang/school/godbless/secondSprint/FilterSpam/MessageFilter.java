package faang.school.godbless.secondSprint.FilterSpam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
