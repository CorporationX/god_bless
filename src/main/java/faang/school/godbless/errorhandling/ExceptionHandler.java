package faang.school.godbless.errorhandling;

@FunctionalInterface
public interface ExceptionHandler {
    void handle(Exception exception);
}
