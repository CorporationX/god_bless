package school.faang.processorerror;


import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        String result = Main.withErrorHandling(
                () -> RemoteService.call("someParam"),  // Основное действие
                e -> {
                    System.out.printf("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("Сервис недоступен");
        }
    }

    public static <T> T withErrorHandling(BaseAction<T> action,
                                          Function<Exception, T> errorHandler) {
        try {
            return action.execute();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }

}
