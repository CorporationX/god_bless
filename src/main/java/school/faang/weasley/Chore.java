package school.faang.weasley;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 17.06.2025
 */
@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {

    private final String name;

    @Override
    public void run() {
        log.info("Поток: {} | Выполняется задача: {}\n", Thread.currentThread().getName(), name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Работа потока {} прервана\n", Thread.currentThread().getName());
        }
        log.info("Поток: {} | Задача выполнена: {}\n", Thread.currentThread().getName(), name);
    }
}
