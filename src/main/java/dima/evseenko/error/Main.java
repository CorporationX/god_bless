package dima.evseenko.error;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(() -> RemoteService.call("error"),
                (e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                })
        );

        System.out.println(result);

        result = ErrorHandler.withErrorHandling(() -> RemoteService.call("test"),
                (e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                })
        );

        System.out.println(result);
    }
}
