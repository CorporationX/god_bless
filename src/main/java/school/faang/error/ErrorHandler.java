package school.faang.error;

public class ErrorHandler {
    public static <T> T withErrorHandling(Caller<T> caller, Recover<T> recover) {
        try {
            return caller.call();
        } catch (Exception e) {
            return recover.process(e);
        }
    }
}
