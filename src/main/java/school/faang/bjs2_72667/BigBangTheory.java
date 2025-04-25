package school.faang.bjs2_72667;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int THREADS_COUNT = 4;
    private static final int EXECUTION_TIMEOUT = 30;

    private static ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

    public static void main(String[] args) {
        executorService.execute(new Task("Sheldon", "preparing theory"));
        executorService.execute(new Task("Leonard", "modeling experiment"));
        executorService.execute(new Task("Howard", "developing instruments"));
        executorService.execute(new Task("Rajesh", "data analysing"));

        shutDown();
    }

    private static void shutDown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(EXECUTION_TIMEOUT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            executorService.shutdownNow();
        }
    }
}