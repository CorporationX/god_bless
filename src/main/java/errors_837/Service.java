package errors_837;

import java.util.function.Supplier;

public class Service {

    public static void main(String[] args) {

        Supplier callServiceError = () -> call(1);
        Supplier callService = () -> call(2);

        ExceptionHandler<String> exceptionHandler = (exeption) -> {
            System.out.println("Запись лога: Не удалось получить доступ к Remote Service. Вернем default значение");
            return "DEFAULT";
        };
        System.out.println(withErrorHandling(callService, exceptionHandler));
        System.out.println(withErrorHandling(callServiceError, exceptionHandler));
    }

    public static String call(int param) {
        if (param == 1) {
            throw new RuntimeException();
        } else {
            System.out.println("SUPER! Все получилось");
            return "Сервис запущен без ошибок";
        }
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exception) {
        try {
            return action.get();
        } catch (Exception ex) {
            return exception.handle(ex);
        }
    }
}