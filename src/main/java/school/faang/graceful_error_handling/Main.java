package school.faang.graceful_error_handling;

public class Main {
    public static void main(String[] args) {
        // Пример с вызовом удалённого сервиса
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),  // Основное действие
                e -> {  // Обработка ошибки
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result);  // Выведет результат: "DEFAULT" при ошибке
    }
}
