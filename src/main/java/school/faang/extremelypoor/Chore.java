package school.faang.extremelypoor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        log.info("Выполнение потока: {}", Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Поток {} прерван: {}", Thread.currentThread().getName(), e.getMessage(), e);
            Thread.currentThread().interrupt();
        }
    }
}
