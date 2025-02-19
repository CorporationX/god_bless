package school.faang;

public class Main {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        String result = exceptionHandler.withErrorHandling(
                () -> remoteService.call("some Param"),
                e -> {
                    System.out.printf("Ошибка при вызове сервиса: %s\n", e.getMessage());
                    return e.getMessage();
                }
        );
        System.out.println(result);
    }
}
