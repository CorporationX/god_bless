package wizardtournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1_000L);
            } catch (InterruptedException e) {
                throw new IllegalArgumentException("Ошибка при вызове метода sleep().");
            }
            school.getTeam().forEach(student -> student.addPoints(task.getReward()));
            return school;
        }, executorService);
    }
}
