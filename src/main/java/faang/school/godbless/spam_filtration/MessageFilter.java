package faang.school.godbless.spam_filtration;

@FunctionalInterface
public interface MessageFilter {

    boolean filter(String message);
}
