package faang.school.godbless.fourth.Tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            performTask(school, task);
            return school;
        });
    }

    private void performTask(School school, Task task) {
        System.out.println("School " + school.name() + " starts to do the task: " + task.name());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
            return;
        }
        System.out.println("Task completed successfully. Each student of the school earned " + task.reward() + " pts.");
        school.team().forEach(student -> student.setPoints(student.getPoints() + task.reward()));
    }
}
