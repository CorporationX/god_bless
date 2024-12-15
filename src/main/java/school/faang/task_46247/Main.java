package school.faang.task_46247;

public class Main {
    public static void main(String[] args) {
        // Вызов удалённого сервиса без ошибки
        String resultNoException = ErrorHandler.withErrorHandling(
                () -> RemoteService.callNoException("someParam"),  // Основное действие
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(resultNoException);

        // Вызов удалённого сервиса с ошибкой
        String resultWithException = ErrorHandler.withErrorHandling(
                () -> RemoteService.callWithException("someParam"),  // Основное действие
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(resultWithException);
    }
}
