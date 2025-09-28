package school.faang.bjs2_92915;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("School %s started task %s%n", school.getName(), task.getName());
                Thread.sleep(task.getDifficulty() * 1000L);
                System.out.printf("School %s completed task %s%n", school.getName(), task.getName());
                for (Student student : school.getTeam()) {
                    student.getPoints().addAndGet(task.getReward());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Task has been interrupted: " + e);
            }
            return school;
        });
    }
}