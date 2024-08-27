package faang.school.godbless.ThreeWizardsTournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executor = Executors.newFixedThreadPool(school.getTeam().size());
        try {
            return CompletableFuture.supplyAsync(() -> {
                for (Student student : school.getTeam()) {
                    try {
                        Thread.sleep(task.getDifficulty() * 1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    student.setPoints(task.getReward());
                }
                return school;
            });
        }
        finally {
            executor.shutdown();
        }
    }
}
