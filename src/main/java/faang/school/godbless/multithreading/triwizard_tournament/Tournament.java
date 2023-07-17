package faang.school.godbless.multithreading.triwizard_tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(school.getName() + " starts the task " + task.getName());
            try {
                Thread.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            school.getStudents().forEach(student -> student.increasePoints(task.getReward()));
            System.out.println(school.getName() + " completes the task " + task.getName());
            return school;
        });
    }
}
