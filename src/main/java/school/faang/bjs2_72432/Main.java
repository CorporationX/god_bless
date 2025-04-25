package school.faang.bjs2_72432;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int AWAIT_TIMEOUT_SECONDS = 30;
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Knight knight1 = new Knight("Jaime Lanister");
        Knight knight2 = new Knight("Lores Thirel");
        knight1.addTrial(new Trial(knight1.getName(), "Fight with a dragon"));
        knight1.addTrial(new Trial(knight1.getName(), "Fight with a giant"));
        knight2.addTrial(new Trial(knight2.getName(), "Love trial"));
        knight2.addTrial(new Trial(knight2.getName(), "Battle for duty"));

        knight1.startTrials(executorService);
        knight2.startTrials(executorService);
        dispose();
    }

    private static void dispose() {
        log.info("Disposing executorService");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.warn("Executor service didn't stop during timeout. Stopping executor service...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Main thread was stopped");
            executorService.shutdownNow();
        }
    }
}