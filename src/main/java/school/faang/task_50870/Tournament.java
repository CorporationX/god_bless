package school.faang.task_50870;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> futureSchool = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(String.format("School %s begin task %s...", school.getName(), task.getName()));
                Thread.sleep(task.getDifficulty() * 1000);
                school.getTeam().forEach(student -> student.addPoints(task.getReward() / school.getTeam().size()));
                System.out.println(String.format("School %s end task %s and get reward %d points", school.getName(),
                        task.getName(), task.getReward()));
                return school;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return school;
        });
        return futureSchool;
    }
}
