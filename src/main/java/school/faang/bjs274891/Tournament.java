package school.faang.bjs274891;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Tournament {
    private static final int DIFFICULTY_DELAY = 300;
    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() *  DIFFICULTY_DELAY);
                int rewardPerStudent = task.getReward() / school.getTeam().size();
                for (Student student : school.getTeam()) {
                    student.addPoints(rewardPerStudent);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return school;
        }, executorService);
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }
}

