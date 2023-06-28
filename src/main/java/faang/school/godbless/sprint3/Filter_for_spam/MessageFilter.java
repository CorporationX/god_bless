package faang.school.godbless.sprint3.Filter_for_spam;

@FunctionalInterface
public interface MessageFilter {
    boolean act(String str);
}
