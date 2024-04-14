package faang.school.godbless.handling_errors;

@FunctionalInterface
interface ExceptionHandler {
    void handleException(Exception e);
}
