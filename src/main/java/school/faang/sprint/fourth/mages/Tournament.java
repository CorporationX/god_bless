package school.faang.sprint.fourth.mages;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final int THREAD_SLEEP_TIME = 1000;
    private final Random random = new Random();


    public CompletableFuture<School> startTask(@NonNull School school, @NonNull Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("School: {} start task: {}", school.getName(), task.getName());
            try {
                Thread.sleep(random.nextInt(THREAD_SLEEP_TIME));
            } catch (InterruptedException e) {
                log.error("Thread sleep interrupted: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
            return Math.round((double) task.getDifficult() * task.getReward() / school.getTeam().size());
        }).thenApply(point -> {
            school.getTeam().forEach(team -> team.setPoints((int) (team.getPoints() + point)));
            return school;
        });
    }
}