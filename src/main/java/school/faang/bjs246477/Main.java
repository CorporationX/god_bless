package school.faang.bjs246477;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(() -> RemoteService.call("someParam", 0), e -> {
            System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
            return "DEFAULT";
        });
        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param, int divisible) {
            int result = 5 / divisible;
            return "result: " + result;
        }
    }
}
