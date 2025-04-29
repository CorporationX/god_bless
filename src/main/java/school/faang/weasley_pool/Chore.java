package school.faang.weasley_pool;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Поток {} выполняет зачаду {}", Thread.currentThread().getName(), chore);
    }
}
