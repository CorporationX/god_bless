package school.faang.future_completable_future.bjs2_2906;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static school.utils.Utils.runWithThreadErrorHandling;
import static school.utils.Utils.shutdownAndAwaitTermination;

public class Tournament {
    private static final int NUMBER_OF_THREADS = 10;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static void stopTasksProcessingAndAwaitTermination() {
        shutdownAndAwaitTermination(EXECUTOR_SERVICE);
    }

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            runWithThreadErrorHandling(() -> Thread.sleep(task.difficulty()));
            school.getStudentForAward().addPoints(task.reward());
            return school;
        }, EXECUTOR_SERVICE);
    }
}