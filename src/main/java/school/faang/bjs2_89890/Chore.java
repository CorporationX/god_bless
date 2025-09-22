package school.faang.bjs2_89890;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@AllArgsConstructor
@Slf4j
public class Chore implements Runnable {
    private static final int MAX_TIME_MILLISECONDS = 7000;
    private String chore;

    @Override
    public void run() {
        log.info("Поток начал выполнение задачи \"{}\"",  chore);
        try {
            Random choreCompletingTime = new Random();
            Thread.sleep(choreCompletingTime.nextInt(MAX_TIME_MILLISECONDS));
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("Поток закончил выполнение задачи \"{}\"", chore);
    }
}
