package faang.school.godbless.functionalInterfaces.spam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
