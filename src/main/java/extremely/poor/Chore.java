package extremely.poor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;
    private static final int MILLIS_FOR_SLEEP = 2000;

    @Override
    public void run() {
        log.info("This task is executed by thread :{}", Thread.currentThread().getName());
        try {
            Thread.sleep(MILLIS_FOR_SLEEP);
        } catch (InterruptedException e) {
            log.error("Задача {} была прервана.", chore);
            Thread.currentThread().interrupt();
        }
    }
}
