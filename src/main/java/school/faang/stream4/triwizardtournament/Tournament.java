package school.faang.stream4.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private static final int THREAD_COUNT = 2;
    private static final long FACTOR = 1000L;
    private final ExecutorService service
            = Executors.newFixedThreadPool(THREAD_COUNT);

    public CompletableFuture<School> startTask(School school, Task task) {

        return CompletableFuture.supplyAsync(() -> {
            log.info("{} started to work on {} task", school.getName(), task.name());
            makeDelayOnTaskPerform(task.difficulty() * FACTOR);
            school.updateScore(task.reward());
            log.info("{} finished with task {} and earn {} points!\n The total score of {} is now {} points!",
                    school.getName(), task.name(), task.reward(), school.getName(), school.getTotalPoints());

            return school;
        },
        service);
    }

    private void makeDelayOnTaskPerform(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            log.error("interrupted exception during task delay: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public void endTournament() {
        log.info("Tournament is over!");
        service.shutdown();
            {
            log.info("Gathering is over!");
            int timeout = 30;
            service.shutdown();
            try {
                if (!service.awaitTermination(timeout, TimeUnit.SECONDS)) {
                    service.shutdownNow();
                }
            } catch (InterruptedException e) {
                service.shutdownNow();
                Thread.currentThread().interrupt();
            }
            }
    }
}
