package school.faang.bjs_48625;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private static final int CHORE_DURATION = 500;
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        log.info("Thread {} start {}", Thread.currentThread().getName(), chore);

        try {
            Thread.sleep(CHORE_DURATION);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
