package faang.school.godbless.multithreading_2.tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
                    List<CompletableFuture<Void>> futures = school.team().stream()
                            .map(student -> doTask(student, task))
                            .toList();

                    futures.forEach(CompletableFuture::join);
                    return school;
        });
    }

    private CompletableFuture<Void> doTask(Student student, Task task) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(task.difficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            student.increasePoints(task.reward());
        });
    }
}
