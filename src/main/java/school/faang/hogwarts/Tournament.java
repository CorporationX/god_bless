package school.faang.hogwarts;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty().getPoints() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            school.getStudentList().stream()
                    .peek(student -> student.updatePoints(task.getReward()))
                    .forEach(System.out::println);
            return school;
        });
    }
}
