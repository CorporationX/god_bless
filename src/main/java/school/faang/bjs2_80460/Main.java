package school.faang.bjs2_80460;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса");
                    return "DEFAULT";
                }
        );
    }
}
