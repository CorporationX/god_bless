package school.faang.task_46217;

public class Main {
    public static void main(String[] args) {
        String result = Action.withErrorHandling(
                () -> {
                    try {
                        return RemoteService.call("Conect");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                e -> {
                    System.out.println("Ошибка при вызове сервиса: " + e.getMessage());
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }
}
