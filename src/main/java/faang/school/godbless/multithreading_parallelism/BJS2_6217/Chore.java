package faang.school.godbless.multithreading_parallelism.BJS2_6217;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@AllArgsConstructor
@Slf4j
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Executing the chore: " + chore + " in " + threadName);

        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            log.error("The chore {} has been interrupted", threadName);
        }
    }
}
