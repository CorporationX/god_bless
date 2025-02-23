package school.faang.triwizardtournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> futureSchool = CompletableFuture.supplyAsync(() -> {
            try {
                school.getStudents()
                        .forEach(student ->
                                student.setPoints(student.getPoints() + task.getReward())
                        );
                Thread.sleep(15L * task.getDifficulty());
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return school;
        });
        return futureSchool;
    }
}
