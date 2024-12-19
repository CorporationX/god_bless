package school.faang.bjs246297;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    try {
                        return RemoteService.call("someParam");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) throws Exception {
            throw new Exception("Сервис недоступен");
        }
    }
}