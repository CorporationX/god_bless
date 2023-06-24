package faang.school.godbless.telegram;

@FunctionalInterface
interface MessageFilter {
    boolean filter(String message);
}
