package school.faang.bjs2_89672;

import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        log.info("Задача {} выполняется...", chore);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("Задача {} была прервана", chore);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("Задача {} выполнена!", chore);
    }

}