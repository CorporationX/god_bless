package school.faang.handling_errors;

/**
 * Проект: god_bless
 * Класс ExceptionHandler
 * Автор: Vital
 * Дата: 22.09.2025
 */

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}