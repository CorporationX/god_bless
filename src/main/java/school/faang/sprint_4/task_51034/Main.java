package school.faang.sprint_4.task_51034;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int RUNNING_TIME = 5000;
    private static final int AWAIT_TIME = 5;

    public static void main(String[] args) {
        MilitaryBase firstBase = new MilitaryBase();
        MilitaryBase secondBase = new MilitaryBase();

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(firstBase);
        executor.execute(secondBase);

        firstBase.sendMessage(secondBase, "First base message");
        secondBase.sendMessage(firstBase, "Second base");

        try {
            Thread.sleep(RUNNING_TIME);

            executor.shutdown();

            if (!executor.awaitTermination(AWAIT_TIME, TimeUnit.SECONDS)) {
                log.info("Awaiteng timed out. Shutting down...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Main thread interrupted");
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdownNow();
        }
    }
}
