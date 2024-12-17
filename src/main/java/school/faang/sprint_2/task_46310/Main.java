package school.faang.sprint_2.task_46310;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса: " + e.getMessage());
                    return "DEFAULT";
                }
        );

        System.out.println(result);

        Integer safeDivision = ErrorHandler.withErrorHandling(
                () -> divide(10, 0),
                e -> {
                    System.out.println("Ошибка при делении: " + e.getMessage());
                    return 0;
                }
        );

        System.out.println(safeDivision);
    }

    public static class RemoteService {
        public static String call(String param) throws Exception {
            throw new Exception("Сервис недоступен");
        }
    }

    public static int divide(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("Деление на ноль");
        }
        return a / b;
    }
}
