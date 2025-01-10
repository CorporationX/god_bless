package school.faang.sprint_4.task_50889;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                synchronized (school) {
                    Thread.sleep(task.getDifficulty() * 1000L);
                    school.getTeam().forEach(student -> {
                        student.setPoints(student.getPoints() + task.getReward() / school.getTeam().size());
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return school;
        });

    }
}
