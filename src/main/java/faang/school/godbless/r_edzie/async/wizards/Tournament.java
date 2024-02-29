package faang.school.godbless.r_edzie.async.wizards;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Start" + school.getName() + " " + task.getName());
            school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return school;
        }, EXECUTOR);
    }
}
