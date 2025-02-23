package BJS2_61016;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    private static final int WAIT_TIMEOUT_MS = 3000;

    public static void main(String[] args) {
        Arrays.stream(CHORES)
                .map(Chore::new)
                .forEach(EXECUTOR::execute);

        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("Some chores were not done at 30 seconds, shutdown now");
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
        }

        try {
            Thread.sleep(WAIT_TIMEOUT_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Main thread was interrupted", e);
            throw new RuntimeException(e);
        }

        log.info("All chores are done");
    }
}
