package school.faang.secondStream.BJS2_33451;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                RemoteService::call,
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public static String call() throws Exception {
            throw new Exception("Сервис недоступен");
        }
    }
}
