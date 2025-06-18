package school.faang.bjs2_81156;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        log.info("Задача `{}` запущена...", chore);
        try {
            TimeUnit.SECONDS.sleep(2);
            log.info("Задача `{}` выполнена!", chore);
        } catch (InterruptedException e) {
            log.warn("Задача `{}` была прервана", chore);
            throw new IllegalStateException("Задача %s была прервана".formatted(chore), e);
        }
    }
}
