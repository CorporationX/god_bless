package school.faang.bjs2_91607;

public class Runner {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("Param"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
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
