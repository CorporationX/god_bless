package faang.school.godbless.SpamFilter;

@FunctionalInterface
public interface MessageFilter {
    public boolean filter(String message);
}
