package school.faang.extremelypoor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        log.info("Выполнение потока: {} для задачи - {}", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5001));
        } catch (InterruptedException e) {
            log.error("Поток {} прерван: {}", Thread.currentThread().getName(), e.getMessage(), e);
            Thread.currentThread().interrupt();
        }
        log.info("Потока: {} для задачи - {} завершен", Thread.currentThread().getName(), chore);
    }
}
