package beautiful.error.handler;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("1233"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "Default";
                }
        );
        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) throws RuntimeException {
            throw new RuntimeException("Сервис недоступен");
        }
    }
}
