package school.faang.moduleone.sprinttwo.task_46240;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(result + "\n" + "*".repeat(30));

        String result2 = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("fineParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(result2);
    }

    public static class RemoteService {
        public static String call(String param) {
            if ("fineParam".equals(param)) {
                return String.format("Удачный вызов c параметром: %s", param);
            }
            throw new RuntimeException("Сервис недоступен");
        }
    }
}
