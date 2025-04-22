package school.faang.exthreadpool;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
        log.info("Обязанность {} создана", this.getChore());
    }

    @Override
    public void run() {
        try {
            log.info("Обязанность {} выполняется в потоке {}",
                    this.getChore(), Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error("Поток {} был прерван", Thread.currentThread().getName(), e);
            Thread.currentThread().interrupt();
        }
    }
}