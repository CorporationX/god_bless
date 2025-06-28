package school.faang.bjs2_82749_three_wiz_tournament;

import lombok.extern.slf4j.Slf4j;
import school.faang.utils.ThreadUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    private static final int SHUTDOWN_DELAY_MINUTES = 10;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void shutDown() {
        ThreadUtils.executorGracefulShutdown(executorService, SHUTDOWN_DELAY_MINUTES, null);
    }

    public CompletableFuture<School> startTask(School school, Task task) {
        log.info("Starting task {} execution for team {}.", task.getName(), school.getName());
        return CompletableFuture.supplyAsync(
                new TaskExecutor(school, task),
                executorService
        );
    }
}
