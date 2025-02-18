package school.faang.sprint2.bjs2_57677;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(() ->
                RemoteService.call(("параметр")),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }
}
