package beautifulErrors;

public class Main {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    return remoteService.call("someParam");
                },
                e -> {
                    System.out.printf("Ошибка %s, при вызове сервиса, возвращаем дефолтное значение%n", e.getMessage());
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }
}
