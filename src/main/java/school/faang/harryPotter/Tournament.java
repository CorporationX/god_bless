package school.faang.harryPotter;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * task.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Задача была прервана " + task.getName());
                throw new RuntimeException(e);
            }
            school.getTeam().stream().peek(
                    student -> student.setPoints(student.getPoints() + task.getReward())
            ).toList();
            return school;
        });
    }
}
