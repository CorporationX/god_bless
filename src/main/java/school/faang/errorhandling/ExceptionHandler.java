package school.faang.errorhandling;
/**
 * Функциональный интерфейс для обработки исключений.
 * <p>
 * Этот интерфейс предназначен для реализации стратегий обработки исключений.
 * Он позволяет определить, как обрабатывать исключение и возвращать результат типа {@code T}.
 * </p>
 * <p>
 * Пример использования:
 * <pre>{@code
 * ExceptionHandler<String> handler = exception -> "Произошла ошибка: " + exception.getMessage();
 * String result = handler.handle(new RuntimeException("Тестовая ошибка"));
 * }</pre>
 * </p>
 *
 * @param <T> тип результата, возвращаемого после обработки исключения
 */

@FunctionalInterface
public interface ExceptionHandler<T> {
    /**
     * Обрабатывает переданное исключение и возвращает результат типа {@code T}.
     * <p>
     * Этот метод должен быть реализован для определения логики обработки исключения.
     * </p>
     *
     * @param exception исключение, которое необходимо обработать
     * @return результат обработки исключения
     */
    T handle(Exception exception);
}
