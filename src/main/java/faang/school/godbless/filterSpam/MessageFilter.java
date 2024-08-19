package faang.school.godbless.filterSpam;

@FunctionalInterface
interface MessageFilter {
    boolean filter(String message);
}
