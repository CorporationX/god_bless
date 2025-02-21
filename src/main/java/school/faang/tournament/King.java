package school.faang.tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class King {
    private static final int THREAD_NUMBER = 2;

    public static void main(String[] args) {
        Knight knight1 = new Knight("Roman");
        Knight knight2 = new Knight("Oleg");
        knight1.addTrial(new Trial("Roman", "go through fire"));
        knight1.addTrial(new Trial("Roman", "fight against tiger"));
        knight2.addTrial(new Trial("Oleg", "fight big man"));
        knight2.addTrial(new Trial("Oleg", "break the stone"));
        List<Knight> knights = List.of(knight1, knight2);
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBER);
        for (Knight knight : knights) {
            knight.startTrials(executor);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.warn("The trials didn't finish in 1 minute, implement force finish");
                executor.shutdownNow();
            } else {
                log.info("The trials finished successfully");
            }
        } catch (InterruptedException e) {
            log.error("The thread was interrupted", e);
            executor.shutdownNow();
        }
    }
}
