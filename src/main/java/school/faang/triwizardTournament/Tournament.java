package school.faang.triwizardTournament;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tournament {
    private static final int THREAD_SLEEP = 5000;
    private static final Logger log = LoggerFactory.getLogger(Tournament.class);
    private static final int THREAD_POOL_COUNT = 2;
    private static final int TIMEOUT = 10;
    private final ExecutorService service;

    public Tournament() {
        this.service = Executors.newFixedThreadPool(THREAD_POOL_COUNT);
    }

    public CompletableFuture<School> startTask(School school, Task task) {

        return CompletableFuture.supplyAsync(() -> {
            threadSleep(THREAD_SLEEP);
            school.getTeam()
                    .forEach(s -> s.addPoints(task.getReward()));
            return school;
        }, service);
    }

    public void shutdown() {
        service.shutdown();
        try {
            if (!service.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted {}", e.getMessage());
        }
    }

    public void threadSleep(int waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            log.error("Thread interrupted ", e);
            Thread.currentThread().interrupt();
        }
    }
}
