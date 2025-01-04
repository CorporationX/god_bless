package school.faang.task_50959;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@AllArgsConstructor
public class Tournament {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<School> startTask(@NonNull School school, @NonNull Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(student -> student.addPoints(task.getReward()));
            System.out.println("Task " + task.getName() + " completed by " + school.getName());
            return school;
        }, executor);
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
