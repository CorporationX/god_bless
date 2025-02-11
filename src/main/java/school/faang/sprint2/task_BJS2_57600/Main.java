package school.faang.sprint2.task_BJS2_57600;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("Some"),
                e -> "DEFAULT");

        System.out.println(result);  // Выведет результат: "DEFAULT"
    }
}
