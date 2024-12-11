package school.faang.sprint_2.task_46180;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) {
            // поменял на RuntimeException и убрал его из сигнатуры метода,
            // ибо отказывалось компилироваться без обработки исключения
            throw new RuntimeException("Сервис недоступен");
        }
    }
}
