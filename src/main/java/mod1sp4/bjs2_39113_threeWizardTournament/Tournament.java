package mod1sp4.bjs2_39113_threeWizardTournament;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Data
@AllArgsConstructor
public class Tournament {

    private final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            long timeoutByDifficulty = task.getDifficulty() * 1000L;
            try {
                Thread.sleep(timeoutByDifficulty);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted while sleeping");
                throw new IllegalStateException(e);
            }
            school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            System.out.println(school.getName() + " заработала очков: " + school.getTotalPoints());
            return school;
        }, executor);
    }

    public void shutdownExecutor() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdown();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred when thread shutting down");
            throw new IllegalStateException(e);
        }
    }
}
