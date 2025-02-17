package school.faang.task_57687;

import lombok.NonNull;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),  // Основное действие
                e -> {  // Обработка ошибки
                    System.out.printf("Ошибка при вызове сервиса: \"%s\" - возвращаем дефолтное значение%n",
                            e.getMessage());
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        private static final int NEGATIVE_STATUS_CODE = 0;
        private static final int POSITIVE_STATUS_CODE = 1;

        public static String call(@NonNull String param) {
            int statusCode = new Random().nextInt(NEGATIVE_STATUS_CODE, POSITIVE_STATUS_CODE + 1);

            if (statusCode == POSITIVE_STATUS_CODE) {
                return String.format("Ответ удалённого сервиса с учётом %s", param);
            }
            throw new RuntimeException("Сервис недоступен");
        }
    }
}
