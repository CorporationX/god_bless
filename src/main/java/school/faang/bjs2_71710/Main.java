package school.faang.bjs2_71710;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call2("someParam"),
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

        public static String call2(String param) {
            return "Сервис недоступен";
        }
    }
}