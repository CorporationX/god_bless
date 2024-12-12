package school.faang.task_46159;

public class Main {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("Service"),  // Основное действие
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }
}
