package bjs292937;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            List<Student> updtedTeam = school.team().stream().map(student -> student.addPoints(task.reward())).toList();
            return new School(school.name(), updtedTeam);
        });
    }
}