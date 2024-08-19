package faang.school.godbless;

@FunctionalInterface
public interface MessageFilter {
    public boolean filter(String message);
}
