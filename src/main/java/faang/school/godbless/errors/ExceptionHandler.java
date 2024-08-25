package faang.school.godbless.errors;

@FunctionalInterface
public interface ExceptionHandler {
    void handle(Exception e);
}
