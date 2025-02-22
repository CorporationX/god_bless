package school.faang.broforce;

/**
 * Функциональный интерфейс, представляющий задачу, которая может быть выполнена
 * и может выбрасывать {@link InterruptedException}.
 * <p>
 * Этот интерфейс аналогичен {@link Runnable}, но позволяет выбрасывать
 * {@link InterruptedException} в случае прерывания потока.
 * <p>
 * Используется для передачи задач, которые могут быть прерваны, например,
 * задач, связанных с блокирующими операциями (ожидание, sleep и т.д.).
 */
@FunctionalInterface
public interface RunnableWithException {
    /**
     * Выполняет задачу, которая может быть прервана.
     *
     * @throws InterruptedException если поток был прерван во время выполнения задачи.
     */
    void run() throws InterruptedException;
}
