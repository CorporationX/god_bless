package school.faang.stream3.parallelismthread.weasleyfamilychore;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            log.info(Thread.currentThread().getName());
            Thread.sleep(3000);
            log.info("task " + chore + " is done\n");
        } catch (InterruptedException e) {
            log.info("task " + chore + " was interrapted\n" + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
