package school.faang.sprint_2.task_46162;

public class Main {


    public static void main(String[] args) {
        ExceptionHandler<String> customErrorHandler = e -> {
            System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
            return "DEFAULT";
        };
        RemoteService remoteService = new RemoteService();

        String resultWithError = ErrorHandler.withErrorHandling(
                () -> remoteService.callWithException("some param"),
                customErrorHandler
        );

        String successResult = ErrorHandler.withErrorHandling(
                () -> remoteService.successCall("some param"),
                customErrorHandler
        );

        System.out.println(resultWithError);
        System.out.println(successResult);
    }
}