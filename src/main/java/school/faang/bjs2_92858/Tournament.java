package school.faang.bjs2_92858;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private static final int THREAD_QUANTITY = 3;
    public final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_QUANTITY);

    public CompletableFuture<School> startQuest(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(task.getDifficulty());
                addPointsToTeam(school.team(), task.getReward());
                log.info("{} успешно выполнили задание", school.name());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Прервали во время выполнения задания");
            }
            return school;
        }, executorService);
    }

    private static void addPointsToTeam(List<Student> team, int points) {
        for (Student student : team) {
            student.addPoints(points);
        }
    }
}
