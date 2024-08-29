package faang.school.godbless.bjs225098;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        List<Student> students = school.getTeam();
        ExecutorService executor = Executors.newFixedThreadPool(students.size());
        List<CompletableFuture<Void>> studentsResultsFuture = new ArrayList<>();
        for (var student : students) {
            CompletableFuture<Void> futureResults = CompletableFuture.runAsync(() -> {
                try {
                    int timeToCompleteTask = (new Random().nextInt(3) + 1);
                    Thread.sleep(timeToCompleteTask * 1000);
                    student.setPoints(task.getDifficulty() / timeToCompleteTask);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, executor);
            studentsResultsFuture.add(futureResults);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            e.printStackTrace();
        }

        return CompletableFuture.allOf(studentsResultsFuture.toArray(new CompletableFuture[0]))
                .thenApply(v -> school);
    }
}