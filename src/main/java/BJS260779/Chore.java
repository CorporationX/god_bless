package BJS260779;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;
    private static final Integer TASK_DURATION_MS = 2000;

    @Override
    public void run() {
        log.info("Поток : " + Thread.currentThread().getName());

        try {
            Thread.sleep(TASK_DURATION_MS);
            log.info("Задача : " + chore + " Выполнена");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Поток был прерван", e);
        }
    }


}
