package school.faang.bjs2_81249;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            log.info("Completing {}", Thread.currentThread().getName());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
