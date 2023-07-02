package faang.school.godbless.Filtering_spam;

@FunctionalInterface
interface MessageFilter{
    boolean filter(String message);
}
