package school.faang.sprint_4.task_51178;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty() * 1000L);
                school.updatePoints(task.reward());
                return school;
            } catch (InterruptedException e) {
                System.out.println("Поток " + Thread.currentThread().getName() + " прервал работу");
                return null;
            }
        });
    }
}
