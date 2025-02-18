package school.faang.task_57695;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    return "Success!";
                },
                e -> {
                    System.out.println("Произошла ошибка: " + e.getMessage());
                    return "Ошибка"; // Возвращаем значение по умолчанию
                }
        );
        log.info("Результат: " + result);

        // Пример с исключением
        String errorResult = ErrorHandler.withErrorHandling(
                () -> {
                    throw new RuntimeException("Что-то пошло не так!");
                },
                e -> {
                    System.out.println("Произошла ошибка: " + e.getMessage());
                    return "Ошибка";
                }
        );
        log.info("Результат: " + errorResult);
    }
}