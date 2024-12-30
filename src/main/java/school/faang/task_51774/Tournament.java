package school.faang.task_51774;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Total points before task for " + school.name() + ": " + school.getTotalPoints());
                System.out.println("Task " + task.name() + " started...");
                Thread.sleep(task.difficulty() * 1000);
                school.team().stream()
                        .forEach(s -> s.setPoints(s.getPoints() + task.reward()));
                System.out.println("Total points after task for " + school.name() + ": " + school.getTotalPoints());
                return  school;
            } catch (InterruptedException  e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Task execution interrupted for " + school.name(), e);
            }
        });
    }
}
