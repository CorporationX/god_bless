package org.example.model.harryPoter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.info(e.getMessage());
                return school;
            }
            school.getTeam()
                    .forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            executorService.shutdown();
            return school;
        }, executorService);
    }
}
