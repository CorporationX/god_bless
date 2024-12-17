package school.faang.sprint2.task_6;


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

        String userResult = ErrorHandler.withErrorHandling(
                () -> {
                    User user = new User("John", "user2@email.com");
                    return user.print("some param");
                },
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(userResult);

        String userError = ErrorHandler.withErrorHandling(
                () -> {
                    User user = new User("John", "user2@email.com");
                    return user.print(null);
                },
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(userError);
    }
}
