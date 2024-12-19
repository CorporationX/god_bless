package faang.school.godbless.sprint_2.task_46273;

public class Main {
    public static void main(String[] args) {
        String someParameter = "Some parameter";
        ThrowableSupplier<String, Exception> mainAction = () -> RemoteService.call(someParameter);
        ExceptionHandler<String> exceptionAction = e -> {
            System.out.println(e.getMessage() + "Ошибка при вызове сервиса, возвращаем дефолтное значение");
            return "DEFAULT";
        };

        String result = ErrorHandler.withErrorHandling(mainAction, exceptionAction);
        System.out.println(result);
    }

    public static class RemoteService {
        private static String call(String parameter) throws Exception {
            throw new Exception("Сервис недоступен");
        }
    }
}
