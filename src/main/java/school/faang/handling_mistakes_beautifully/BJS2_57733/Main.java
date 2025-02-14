package school.faang.handling_mistakes_beautifully.BJS2_57733;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.callService("Gondor is calling for help!"),
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

        public static String callService(String help) {
            return help;
        }
    }
}
