package faang.school.godbless.BJS2_25050;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Tournament {
    private static final Random RANDOM = new Random();
    private ExecutorService executor;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            boolean isWin = RANDOM.nextBoolean();

            try {
                Thread.sleep(task.getExecutionTime());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.printf("Школа \"%s\" сделала таску %s: %b%n", school.getName(), task.getName(), isWin);

            if (isWin) {
                school.addPoints(task.getReward());
            }
            shutdown();
            return school;
        }, executor);
    }

    private void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(7, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
