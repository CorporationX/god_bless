package school.faang.bjs2_89740;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Chore implements Runnable {
    private String chore;
    private static final int THREAD_SLEEP = 1000;

    @Override
    public void run() {
        try {
            log.info("Выполняется задача {}", chore);
            Thread.sleep(THREAD_SLEEP);
            log.info("Задача \"{}\" выполнена", chore);
        } catch (InterruptedException e) {
            log.info("Задача \"{}\" была прервана", chore);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }


}
