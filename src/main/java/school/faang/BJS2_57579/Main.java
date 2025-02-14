package school.faang.BJS2_57579;

public class Main {
    private static final String DEFAULT_VALUE = "DEFAULT";
    private static final String message = "Ошибка при вызове сервиса, возвращаем дефолтное значение\n";

    public static void main(String[] args) {
        String s = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.printf(message);
                    return DEFAULT_VALUE;
                }
        );
        System.out.printf("%s\n", s);
        System.out.print("-----------------\n");
        String s2 = ErrorHandler.withErrorHandling(
                () -> RemoteService.call(null),
                e -> {
                    System.out.printf(message);
                    return DEFAULT_VALUE;
                }
        );
        System.out.printf("%s\n", s2);
    }
}
