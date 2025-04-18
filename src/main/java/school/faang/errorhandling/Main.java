package school.faang.errorhandling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ErrorExample.withErrorHandling(
                () -> {
                    System.out.println("Основное действие выполнено");
                    return "Acion";
                },
                e -> {
                    log.error("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                });

        ErrorExample.withErrorHandling(
                () -> {
                    throw new RuntimeException();
                },
                e -> {
                    log.error("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                });
    }
}