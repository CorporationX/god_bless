package school.faang.tournir;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class King {
    private static final int POOL_SIZE = 2;
    private static final int AWAITING_SECONDS = 10;

    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        Knight knight = new Knight("Arthur");
        Knight knight2 = new Knight("Lens");

        Trial trial = new Trial(knight.getName(), "Fight");
        Trial trial2 = new Trial(knight.getName(), "Horse racing");
        Trial trial3 = new Trial(knight2.getName(), "Swimming");
        Trial trial4 = new Trial(knight2.getName(), "Running");

        knight.addTrial(trial);
        knight.addTrial(trial2);
        knight2.addTrial(trial3);
        knight2.addTrial(trial4);

        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

        knight.startTrials(executorService);
        knight2.startTrials(executorService);

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
