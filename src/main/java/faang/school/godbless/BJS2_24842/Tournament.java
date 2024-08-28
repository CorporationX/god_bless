package faang.school.godbless.BJS2_24842;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {

    private final int threadPoolSize = 5;
    private final ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (school) {
                System.out.println(school.getName() + " started task - " + task.getName());
                try {
                    TimeUnit.SECONDS.sleep(task.getDifficulty());
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    throw new RuntimeException(e);
                }
                school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));

                System.out.println(school.getName() + " ended task - " + task.getName());
            }
            return school;
        }, executorService);
    }

    public void shutdown() {
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("all threads completed");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
