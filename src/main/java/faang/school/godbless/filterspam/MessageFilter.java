package faang.school.godbless.filterspam;
@FunctionalInterface
interface MessageFilter {
    public boolean filter(String message);
}
