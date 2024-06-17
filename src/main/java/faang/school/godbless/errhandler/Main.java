package faang.school.godbless.errhandler;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws Exception {
        ExceptionHandler handler = Throwable::printStackTrace;
        withErrorHandling(()->"Hello",handler);
    }
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler err) throws Exception {
        try {
            return action.get();
        } catch (Exception e) {
            err.handleError(e);
            return null;
        }
    }
}
