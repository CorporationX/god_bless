package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private final ExecutorService executor;

    public QuestSystem(int poolSize) {
        this.executor = Executors.newFixedThreadPool(poolSize);
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            quest.executeQuest(player);
            return player;
        }, executor);
    }

    public void shutdownExecutorService() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.warn("Executor did not terminate in the specific time. Forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Executor shutdown was interrupted", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}