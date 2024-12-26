package school.faang.task_51800;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> futureSchool = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(task.getDifficulty() * 1000);
                    } catch (InterruptedException e) {
                        System.out.println("Exception " + e);
                    }

                    school.getTeam().stream()
                            .forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
                    return school;
                });
        return futureSchool;
    }
}
