package faang.school.godbless.messenger;

@FunctionalInterface
interface MessageFilter {
    boolean filter(String message);
}