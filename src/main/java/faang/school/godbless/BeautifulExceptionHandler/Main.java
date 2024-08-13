package faang.school.godbless.BeautifulExceptionHandler;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {

        int result = withErrorHandling(() -> {
            return 4/0;
        }, (e) -> {
            System.out.println(e.getMessage() + " ОЧЕНЬ ПЕЧАЛЬНО");
        });

    }

    public static<T> T withErrorHandling(Callable<T> callable, ExceptionHandler exceptionHandler) {

        T result = null;
        try {
            result = callable.call();
        } catch (Exception e) {
            exceptionHandler.handle(e);
        }
        return result;
    }
}
