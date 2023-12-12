package faang.school.godbless.filter_spam;
@FunctionalInterface
public interface MessageFilter {
    boolean apply(String message);
}
