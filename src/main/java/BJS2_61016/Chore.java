package BJS2_61016;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private final String title;

    @Override
    public void run() {
        try {
            log.info("{} is started doing {} chore", Thread.currentThread().getName(), title);
            Thread.sleep(1000);
            log.info("{} is done", title);
        } catch (InterruptedException e) {
            log.error("{} was interrupted", title);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
