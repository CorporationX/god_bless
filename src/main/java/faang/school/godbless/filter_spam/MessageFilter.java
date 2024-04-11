package faang.school.godbless.filter_spam;

@FunctionalInterface
public interface MessageFilter {
    public boolean filter(String message);
}
