package school.faang.kingtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Runner {
    private static final int THREAD_COUNTER = 2;
    private static final int SECOND = 10;

    public static void main(String[] args) {
        Knight lord = new Knight("Lord");
        Knight bob = new Knight("Bob");
        lord.addTrial(new Trial("Run", lord.getName()));
        bob.addTrial(new Trial("Run", bob.getName()));
        lord.addTrial(new Trial("Fight", lord.getName()));
        bob.addTrial(new Trial("Fight", bob.getName()));
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNTER);
        lord.startTrials(executor);
        bob.startTrials(executor);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(SECOND, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage(), e);
        }


    }
}
