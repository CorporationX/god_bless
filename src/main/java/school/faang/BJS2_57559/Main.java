package school.faang.BJS2_57559;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.printf(
                            "Ошибка при вызове сервиса, возвращаем дефолтное значение, Тип ошибки: %s ",
                            e.getMessage());
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("Сервис недоступен");
        }
    }
}
