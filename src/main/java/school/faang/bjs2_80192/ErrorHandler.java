package school.faang.bjs2_80192;

public class ErrorHandler {
    public static <T> T withErrorHandling(Runnable runnable, ErrorFunction<T> errorFunction) {
        T result = null;
        try {
            runnable.run();
        } catch (Exception e) {
            result = errorFunction.action(e);
        }
        return result;
    }
}
