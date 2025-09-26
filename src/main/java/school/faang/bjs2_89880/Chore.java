package school.faang.bjs2_89880;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            log.info("Выполняется задача: {}", chore);
            Thread.sleep(1000);
            log.info("Задача {} выполнена", chore);
        } catch (InterruptedException e) {
            log.error("Задача {} была прервана", chore, e);
            Thread.currentThread().interrupt();
        }
    }
}
