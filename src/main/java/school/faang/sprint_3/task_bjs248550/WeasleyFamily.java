package school.faang.sprint_3.task_bjs248550;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {

    public static void main(String[] args) {
        List<String> chores = TestDataGenerator.getRandomChores(100);
        log.info(chores.toString());

        ExecutorService executorService = Executors.newCachedThreadPool();
        chores.forEach(chore -> executorService.execute(new Chore(chore)));

        executorService.shutdown();
        executorServiceShutdownNowWithHandler(executorService, 5, TimeUnit.SECONDS);
        log.info("All tasks completed");
    }

    private static void executorServiceShutdownNowWithHandler(
            ExecutorService executorService, long timeout, TimeUnit timeUnit) {
        try {
            if (!executorService.awaitTermination(timeout, timeUnit)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
