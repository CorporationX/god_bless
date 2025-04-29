package school.faang.extremely_poor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static school.faang.extremely_poor.WeasleyFamily.chores;

@Slf4j
public class Main {
    private static final int AWAITING_SECONDS = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        chores.forEach(executorService::execute);
        softShutdown(executorService);
    }

    public static void softShutdown(ExecutorService executor) {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAITING_SECONDS, TimeUnit.SECONDS)) {
                log.warn("Execution is not terminated in time. Forced shutdown!");
                executor.shutdownNow();
            } else {
                log.info("Execution is terminated successful!");
            }
        } catch (InterruptedException e) {
            log.error("Principal Thread is interrupted");
            executor.shutdownNow();
        }
    }
}
