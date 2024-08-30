package com.multithreading.tournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private ExecutorService service = Executors.newFixedThreadPool(2);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            school.getTeam().forEach(student -> student.setPoints(task.getReward()));
            return school;
        }, service).thenApply(school1 -> {
            school1.setTotalPoints(school1.getTeam().stream().mapToInt(Student::getPoints).sum());
            service.shutdown();
            return school1;
        });
    }
}
