package school.faang.task60791;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Chore implements Runnable {
    private static final String TASK_MESSAGE = "Задача: {}, поток: {}";
    private static final String SUCCESS_MESSAGE = "Готово: {}, поток: {}";
    private static final String ERROR_MESSAGE = "Ошибка: {}, поток: {}";
    private static final String INTERRUPTED_MESSAGE = "Ожидание прервано";
    private static final int SLEEP_TIME = 4000;
    private final String title;

    @Override
    public void run() {
        log.info(TASK_MESSAGE, title, Thread.currentThread().getName());
        try {
            Thread.sleep(SLEEP_TIME);
            log.info(SUCCESS_MESSAGE, title, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            log.error(ERROR_MESSAGE, title, Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            throw new RuntimeException(INTERRUPTED_MESSAGE, e);
        }
    }
}
