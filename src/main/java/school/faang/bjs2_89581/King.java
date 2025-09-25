package school.faang.bjs2_89581;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class King {

    public static void main(String[] args) {

        Knight knight1 = new Knight("John Snow");
        Knight knight2 = new Knight("Ned Stark");

        Trial trial1 = new Trial(knight1.getName(), "Pancake eating");
        knight1.addTrial(trial1);
        Trial trial2 = new Trial(knight1.getName(), "Cola drinking");
        knight1.addTrial(trial2);
        Trial trial3 = new Trial(knight2.getName(), "Pizza eating");
        knight2.addTrial(trial3);
        Trial trial4 = new Trial(knight2.getName(), "Tea drinking");
        knight2.addTrial(trial4);

        ExecutorService exec = Executors.newFixedThreadPool(4);

        knight1.startTrials(exec);
        knight2.startTrials(exec);

        exec.shutdown();
        try {
            if (!exec.awaitTermination(1, TimeUnit.MINUTES)) {
                log.warn("This is taking too long");
                exec.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Trials have been interrupted");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("Trials have been completed");
    }
}
