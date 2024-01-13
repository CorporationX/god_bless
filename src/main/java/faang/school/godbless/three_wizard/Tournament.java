package faang.school.godbless.three_wizard;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        List<Student> students = school.getTeam();
        ExecutorService executor = Executors.newFixedThreadPool(students.size());
        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
            students.forEach(student -> student.setPoints(task.getReward()));
            return school;
        }, executor);
        executor.shutdown();
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future);
        return future;
    }
}
