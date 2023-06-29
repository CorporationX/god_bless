package faang.school.godbless.sprint3.SpamFilter;

@FunctionalInterface
interface MessageFilter {
    public boolean filter(String message);
}
