package faang.school.godbless.filteringspam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
