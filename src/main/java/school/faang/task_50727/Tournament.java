package school.faang.task_50727;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> futureResult = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }
            System.out.println("Текущий таск " + task.getName() + " закончил свое выполнение");
            return school;
        }, executor);
        return futureResult;
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }

}
