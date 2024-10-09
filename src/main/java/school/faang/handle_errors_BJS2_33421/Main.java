package school.faang.handle_errors_BJS2_33421;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    try {
                        return RemoteService.call("someParam");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
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
