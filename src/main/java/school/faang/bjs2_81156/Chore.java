package school.faang.bjs2_81156;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        log.info("Задача `{}` запущена в {}...", chore, Thread.currentThread().getName());
        try {
            Thread.sleep(1500);
            log.info("Задача `{}` выполнена!", chore);
        } catch (InterruptedException e) {
            log.warn("Задача `{}` была прервана", chore);
            throw new RuntimeException(e);
        }
    }
}
