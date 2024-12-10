package school.faang.task_46222;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Exception при вызове сервиса: " + e);
                    System.out.println("Возвращаем дефолтное значение:");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }
}
