package school.faang.stream4.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    private final int threadCount = 2;
    private final ExecutorService service
         = Executors.newFixedThreadPool(threadCount);

    public CompletableFuture<School> startTask(School school, Task task) {

        return CompletableFuture.supplyAsync(() -> {
            log.info("{} started to work on {} task", school.getName(), task.name());
            makeDelayOnTaskPerform(task);
            school.updateScore(task.reward());
            log.info("{} finished with task {} and earn {} points!\n The total score of {} is now {} points!",
                    school.getName(), task.name(), task.reward(), school.getName(), school.getTotalPoints());

            return school;
        },
        service);
    }

    private void makeDelayOnTaskPerform(Task task) {
        long millis = 1000L * task.difficulty();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("interrupted exception during task delay: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public void endTournament() {
        log.info("Tournament is over!");
        this.service.shutdown();
    }
}
