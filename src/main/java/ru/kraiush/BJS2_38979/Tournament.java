package ru.kraiush.BJS2_38979;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (Student student : school.getTeam()) {
                student.getReward(task.getReward());
            }
            return school;
        });
    }

    public CompletableFuture<School> getWinningSchool(List<CompletableFuture<School>> schools) {
        return CompletableFuture.allOf(schools.toArray(new CompletableFuture[0]))
                .thenApply(school -> schools.stream()
                        .map(CompletableFuture::join)
                        .reduce((school1, school2) -> school1.getTotalPoints() > school2.getTotalPoints() ? school1 : school2)
                        .orElse(null));
    }
}
