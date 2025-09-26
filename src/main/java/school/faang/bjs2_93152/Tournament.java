package school.faang.bjs2_93152;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Tournament {
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(school.getName() + " начала задание: " + task.getName());
                Thread.sleep(task.getDifficulty() * 1000L);

                school.addPointsToAll(task.getReward());

                System.out.println(school.getName() + " завершила задание: " + task.getName() +
                        " (+ " + task.getReward() + " очков каждому)");

                return school;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Задание прервано", e);
            }
        }, executor);
    }

    public static void shutdown() {
        executor.shutdown();
    }
}