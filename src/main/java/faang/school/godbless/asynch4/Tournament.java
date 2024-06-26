package faang.school.godbless.asynch4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> getSchool(school, task), executor);
        doingTask(task);
        executor.shutdown();
        return future;
    }

    private static void doingTask(Task task) {
        try {
            Thread.sleep(task.difficulty() * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static School getSchool(School school, Task task) {
        school.team().forEach(student -> setNewPoints(task, student));
        return school;
    }

    private static void setNewPoints(Task task, Student student) {
        student.setPoints(student.getPoints() + task.reward());
    }
}
