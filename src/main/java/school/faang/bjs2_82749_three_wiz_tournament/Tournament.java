package school.faang.bjs2_82749_three_wiz_tournament;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.utils.ThreadUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Slf4j
public class Tournament {
    private static final int SHUTDOWN_DELAY_MINUTES = 10;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void shutDown() {
        ThreadUtils.executorGracefulShutdown(executorService, SHUTDOWN_DELAY_MINUTES, null);
    }

    @RequiredArgsConstructor
    private static class TaskExecutor implements Supplier<School> {
        private final School school;
        private final Task task;

        @Override
        public School get() {
            try {
                TimeUnit.SECONDS.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                log.error("Task execution failed: {}, {}", task.getName(), e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            log.info("Task {} successfully completed by team {}.", task.getName(), school.getName());
            school.getTeam()
                    .forEach(s -> s.addPoints(task.getDifficulty()));
            return school;
        }
    }

    public CompletableFuture<School> startTask(School school, Task task) {
        log.info("Starting task {} execution for team {}.", task.getName(), school.getName());
        return CompletableFuture.supplyAsync(
                new TaskExecutor(school, task),
                executorService
        );
    }
}
