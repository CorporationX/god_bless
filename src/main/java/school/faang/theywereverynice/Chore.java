package school.faang.theywereverynice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private static final int ONE_SECOND = 1000;
    private final String title;

    @Override
    public void run() {
        log.info("Поток {} выполняет задачу: {}", Thread.currentThread().getName(), title);
        try {
            Thread.sleep(ONE_SECOND);
        } catch (InterruptedException e) {
            log.info("Задача {} была прервана.", title);
        }
        log.info("Задача {} выполнена.", title);
    }
}
