package BJS2_24875_ThreeWizzardTournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted!", e);
            }
            int pointsForStudent = (task.getDifficulty() * task.getReward()) / school.getTeam().size();
            for (Student student : school.getTeam()) {
                student.setPoints(pointsForStudent);
            }
            return school;
        }, executor).whenComplete((result, throwable) -> executor.shutdown());
    }
}
