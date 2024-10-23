package school.faang.triwizardtournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            int addPoints = task.reward() / school.getStudents().size();
            school.getStudents().stream()
                    .peek(student -> student.setPoints(student.getPoints() + addPoints));
            try {
                Thread.sleep(task.difficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Ошибка метода Tournament.startTask", e);
            }
            return school;
        });
    }
}
