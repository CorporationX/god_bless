package faang.school.godbless.spam.filter;

@FunctionalInterface
interface MessageFilter {
    boolean filter(String message);
}
