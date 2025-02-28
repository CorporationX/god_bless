package BJS262410;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        if (school == null || task == null) {
            log.error("School and task are null!");
            return CompletableFuture.completedFuture(null);
        }

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Task execution interrupted", e);
            }
            school.getTeam().forEach(team -> {
                team.setPoints(team.getPoints() + task.getReward());
            });
            return school;
        }).thenApply(updatedSchool -> {
            log.info("School: {} had: {} points | after task have: {} points",
                    updatedSchool.getName(),
                    school.getTotalPoints() - task.getReward() * school.getTeam().size(),
                    updatedSchool.getTotalPoints());
            return updatedSchool;
        });

    }
}
