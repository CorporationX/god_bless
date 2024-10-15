package Sprint_2.BJS2_33389;


import java.util.function.Function;

public class Main {

    public static class ErrorHandler {
        public static <T> T withErrorHandling(ActionWithException<T> action, Function<Exception, T> errorHandler) {
            try {
                return action.execute();

            } catch (Exception e) {
                return errorHandler.apply(e);
            }
        }
    }

    public static void main(String[] args) {
        //  вызов удалённого сервиса
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),  // Основное действие
                e -> {  // Обработка
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }
}