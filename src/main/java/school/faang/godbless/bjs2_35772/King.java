package school.faang.godbless.bjs2_35772;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class King {
    private static final int NUMBER_OF_THREADS = 2;

    public static void main(String[] args) {
        Knight knight1 = new Knight("knight1");
        Knight knight2 = new Knight("knight2");

        knight1.addTrial(new Trial(knight1.getName(), "Trial1"));
        knight1.addTrial(new Trial(knight1.getName(), "Trial2"));
        knight1.addTrial(new Trial(knight1.getName(), "Trial3"));
        knight1.addTrial(new Trial(knight1.getName(), "Trial4"));

        knight2.addTrial(new Trial(knight2.getName(), "Trial1"));
        knight2.addTrial(new Trial(knight2.getName(), "Trial2"));
        knight2.addTrial(new Trial(knight2.getName(), "Trial3"));
        knight2.addTrial(new Trial(knight2.getName(), "Trial4"));
        knight2.addTrial(new Trial(knight2.getName(), "Trial5"));

        ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        pool.submit(knight1::startTrials);
        pool.submit(knight2::startTrials);
        pool.shutdown();
        try {
            if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
                log.info("The tourney is over");
            } else {
                log.error("The pool is not terminated");
            }
        } catch (InterruptedException e) {
            log.error("Main thread interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
