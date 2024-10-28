package dima.evseenko.wizard;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<School> startTask(School school, Task task) {
        if (executor.isShutdown()) {
            executor = Executors.newCachedThreadPool();
        }

        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
            try {
                school.getTeem().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
                Thread.sleep(task.getDifficulty().getTaskCompleteTime());
                return school;
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new IllegalStateException("Ошибка выполнения задачи %s школой %s".formatted(task.getName(), school.getName()), e);
            }
        }, executor);

        executor.shutdown();

        return future;
    }
}
