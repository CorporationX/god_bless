package school.faang.bjs2_81136;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String choreName;

    @Override
    public void run() {
        try {
            log.info("Поток выполняет задачу: {}", choreName);
            TimeUnit.SECONDS.sleep(3);
            log.info("Задача \"{}\" успешно выполнена", choreName);
        } catch (InterruptedException e) {
            log.error("Interrupted while doing the chore: {}", choreName);
            Thread.currentThread().interrupt();
            log.error("Stack trace: ", e);
        }
    }
}
