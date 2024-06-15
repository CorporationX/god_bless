package faang.school.godbless.domain.task_spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String string);
}
