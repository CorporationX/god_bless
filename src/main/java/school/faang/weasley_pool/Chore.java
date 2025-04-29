package school.faang.weasley_pool;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private String chore;
    private static final long DELAY_MS = 5L;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("Поток {} выполняет зачаду {}", Thread.currentThread().getName(), chore);
    }
}
