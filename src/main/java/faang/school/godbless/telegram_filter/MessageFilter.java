package faang.school.godbless.telegram_filter;

@FunctionalInterface
interface MessageFilter {
    boolean filter(String message);
}
