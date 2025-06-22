package school.faang.bigbang;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Slf4j(topic = "Task")
@RequiredArgsConstructor
public class Task implements Runnable {

    private static final int MIN_RAND_NUM = 1;
    private static final int MAX_RAND_NUM = 5;

    private final Random rand = new Random();

    /**
     * Имя исполнителя
     */
    private final String name;

    /**
     * Задача
     */
    private final String task;

    @Override
    public void run() {
        log.info("{} начал работу над '{}'", name, task);
        try {
            Thread.sleep(rand.nextInt(MIN_RAND_NUM, MAX_RAND_NUM));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Задача '{}' прервана", task, e.getCause());
            return;
        }
        log.info("{} завершил '{}'", name, task);
    }
}
