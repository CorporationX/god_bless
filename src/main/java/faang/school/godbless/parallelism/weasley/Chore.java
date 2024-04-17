package faang.school.godbless.parallelism.weasley;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore; //the name of the chore


    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        log.info("Executing a " + chore + " chore by " + threadName);
        try {
            Thread.sleep(new Random().nextInt(5, 10) * 1000L);
        } catch (InterruptedException e) {
            log.error("Something interrupted " + chore + " chore in " + threadName, e);
        }
        log.info(chore + " chore was executed by " + threadName);
    }
}
