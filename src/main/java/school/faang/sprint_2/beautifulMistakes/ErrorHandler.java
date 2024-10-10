package school.faang.sprint_2.beautifulMistakes;

public class ErrorHandler {
    public static <T> T withErrorHandling(ThrowableException<T> action, ExceptionHandling<T> handling) {
        try {
            return action.apply();
        } catch (Exception e) {
            return handling.handle(e);
        }
    }
}