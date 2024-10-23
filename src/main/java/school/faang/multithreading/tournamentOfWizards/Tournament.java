package school.faang.multithreading.tournamentOfWizards;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Students of " + school.getName() + " are started to complete the task: " + task.getName());
                Thread.sleep(1000 * task.getDifficulty());
                school.awardPointsToAllStudents(task);
            } catch (InterruptedException e) {
                System.out.println("Students of " + school.getName() + " interrupted the task");
                e.printStackTrace();
            }
            return school;
        }, executor);
    }
}
