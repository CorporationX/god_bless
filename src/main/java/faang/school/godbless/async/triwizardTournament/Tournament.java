package faang.school.godbless.async.triwizardTournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

@Slf4j
public class Tournament {
    private static final long MIN_TIMEOUT = 3000L;
    private static final ExecutorService THREAD_POOL = Executors.newCachedThreadPool();

    public CompletableFuture<School> startTask(School school, Task task) {
        Supplier<School> taskExecutor = () -> {
            var randomTimeout = ThreadLocalRandom.current().nextLong(1000);

            try {
                Thread.sleep(MIN_TIMEOUT + randomTimeout * task.difficulty());
            } catch (InterruptedException e) {
                log.error("Task (" + task.name() + ") execution was interrupted.", e);
            }

            return school;
        };

        return CompletableFuture.supplyAsync(taskExecutor, THREAD_POOL)
                .thenApply(schoolAfterTask -> schoolAfterTask.updatePoints(task.reward()));
    }
}
