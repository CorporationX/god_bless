package school.faang.exthreadpool;

import lombok.AllArgsConstructor;
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
        log.info("Обязанность {} выполняется в потоке {}",
                this.getChore(), Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("метод {} на потоке {} не выполнен, поймано исключение {}",
                    "sleep", Thread.currentThread().getName(), e.getMessage());
        }
    }
}