package school.faang.sprint_4.task_threewizardturnamentbjs2n50814;

import lombok.NonNull;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static int DEFAULT_DELAY = 1000;

    public synchronized CompletableFuture<School> startTask(School school, Task task) {
        try {
            Thread.sleep((long) DEFAULT_DELAY * task.getDifficulty());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CompletableFuture<School> executorFuture = CompletableFuture.supplyAsync(() -> doTournament(school, task));
        return executorFuture;
    }

    private School doTournament(@NonNull School school, @NonNull Task task) {
        int randomStudent = (int) (Math.random() * school.getTeam().size());
        school.getTeam().get(randomStudent)
                .addPoints(task.getReward());
        return school;
    }
}
