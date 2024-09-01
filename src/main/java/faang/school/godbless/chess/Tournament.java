package faang.school.godbless.chess;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture<School> updatedSchool = CompletableFuture.supplyAsync(() -> {
            school.team().forEach(student -> student.setPoints(student.getPoints() + task.reward()));
            return school;
        }, executorService);

        executorService.shutdown();

        return updatedSchool;
    }
}
