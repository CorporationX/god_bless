package faang.school.godbless.multithreading_async.the_triwizard_tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {


    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                performTask(school, task);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return school;
        });
    }

    private void performTask(School school, Task task) {
        System.out.println("Name: " + Thread.currentThread().getName());
        school.getTeam().forEach(student -> student.setPoints(task.getReward() * task.getDifficulty()));
    }
}
