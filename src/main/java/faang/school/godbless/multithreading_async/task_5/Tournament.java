package faang.school.godbless.multithreading_async.task_5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private static final int THREAD_COUNT = 2;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_COUNT);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            school.team().forEach(student -> student.addPoints(task.reward()));
            return school;
        }, EXECUTOR);
    }

    public void shutdownExecutor() {
        EXECUTOR.shutdown();
    }
}
