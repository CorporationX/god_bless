package school.faang.sprint_2.task_46154;

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
}
//