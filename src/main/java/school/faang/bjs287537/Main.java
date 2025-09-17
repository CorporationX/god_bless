package school.faang.bjs287537;

import static school.faang.bjs287537.ErrorHandler.withErrorHandling;

public class Main {
    public static void main(String[] args) {
        String result = withErrorHandling(
            () -> RemoteService.call("someParam"),  // Основное действие
            e -> {
                System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                return "DEFAULT";
            }
        );

        System.out.println(result);
    }
}
