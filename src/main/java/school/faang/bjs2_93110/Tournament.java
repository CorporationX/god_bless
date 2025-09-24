package school.faang.bjs2_93110;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private static final int NUM_THREADS = 5;
    private static final int COEFFICIENT_DIFFICULTY = 1000;
    private static final int TIMEOUT = 15;
    private ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                Random randomStudent = new Random();
                Student student = school.getTeam().get(randomStudent.nextInt(0, school.getTeam().size()));
                synchronized (student) {
                    student.setPoints(student.getPoints() + task.getReward());
                    log.info("Волшебник {} выполнил задачу {} и заработал {} очков для {}",
                            student.getName(),
                            task.getName(),
                            task.getReward(),
                            school.getName());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(e.getMessage());
            }
            return school;
        }, executorService);
    }

    public void shutdownCorrectly() {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Все задачи выполнены");
            } else {
                log.info("Задачи не успели выполниться вовремя");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
    }
}
