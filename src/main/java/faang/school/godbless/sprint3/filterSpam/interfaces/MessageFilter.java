package faang.school.godbless.sprint3.filterSpam.interfaces;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
