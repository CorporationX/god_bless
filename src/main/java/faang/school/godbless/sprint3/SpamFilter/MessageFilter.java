package faang.school.godbless.sprint3.SpamFilter;

@FunctionalInterface
public interface MessageFilter {
    public boolean filter(String message);
}
