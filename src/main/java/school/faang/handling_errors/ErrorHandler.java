package school.faang.handling_errors;

import java.util.function.Supplier;

/**
 * Проект: god_bless
 * Класс ErrorHandler
 * Автор: Vital
 * Дата: 22.09.2025
 */

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}