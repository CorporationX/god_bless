package school.faang.errors;

public class ErrorHandler {
    public static <T> T withErrorHandling(MainFunction<T> mainFunk, ExceptionError<T> errorFunk) {
        try {
            return mainFunk.execute();
        } catch (Exception e) {
            return errorFunk.handle(e);
        }
    }

    public interface MainFunction<T> {
        T execute() throws Exception;
    }

    public interface ExceptionError<T> {
        T handle(Exception e);
    }
}
