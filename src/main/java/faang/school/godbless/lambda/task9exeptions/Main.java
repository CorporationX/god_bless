package faang.school.godbless.lambda.task9exeptions;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        String result = withErrorHandling(
                () -> remoteService.call("param"),
                e -> System.out.println("Не удалось получить доступ к Remote Service. : " + e.getMessage())
        );

        System.out.println(result);
    }

    public static <T> T withErrorHandling(Callable<T> action, ExceptionHandler exceptionHandler) {
        try {
            return action.call();
        } catch (Exception e) {
            exceptionHandler.handleException(e);
            return (T) "ПОПРОБУЙ ЕЩЕ РАЗ!\nПРОБУЙ ЛУЧШЕ!";
        }
    }


}
