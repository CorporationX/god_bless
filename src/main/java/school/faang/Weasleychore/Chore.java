package school.faang.Weasleychore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Chore implements Runnable {
    private String choreName;

    @Override
    public void run() {
        try {
            log.info("{} started {}", Thread.currentThread().getName(), choreName);
            Thread.sleep(5000);
            log.info("{} finished {}", Thread.currentThread().getName(), choreName);
        } catch (InterruptedException e) {
            log.warn("{} interrupted", choreName);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}