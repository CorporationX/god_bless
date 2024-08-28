package triwizard.tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static final int TASK_DELAY = 5000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("School: %s started task: %s\n", school.getName(), task.getName());
            try {
                Thread.sleep(TASK_DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            school.getTeam().forEach(student -> {
                if (task.getDifficulty() * task.getReward() < student.getPoints()) {
                    student.setPoints(student.getPoints() + task.getReward());
                }
            });

            System.out.printf("School: %s ended task: %s\n", school.getName(), task.getName());

            return school;
        });
    }
}
