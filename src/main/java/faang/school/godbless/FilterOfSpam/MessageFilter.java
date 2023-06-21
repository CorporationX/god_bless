package faang.school.godbless.FilterOfSpam;

@FunctionalInterface
public interface MessageFilter {
    Boolean filter(String message);
}
