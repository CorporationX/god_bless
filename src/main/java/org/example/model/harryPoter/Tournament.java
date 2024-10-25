package org.example.model.harryPoter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
                return school;
            }
            school.getTeam()
                    .forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            return school;
        }, executorService);
    }

    public void shutdownPoolThreads() {
        executorService.shutdown();
    }
}
