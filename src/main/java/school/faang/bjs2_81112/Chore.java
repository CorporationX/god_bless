package school.faang.bjs2_81112;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private static final int TIMEOUT = 5000;
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            log.info("Поток {} начал задачу '{}'", threadName, chore);
            Thread.sleep(TIMEOUT);
            log.info("Поток {} завершил задачу '{}'", threadName, chore);

        } catch (InterruptedException e) {
            log.info("Поток {} был прерван", threadName);
        }

    }
}
