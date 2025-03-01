package wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int TERMINATION_TIME_SEC = 60;
    private static final int THREAD_POOL = Runtime.getRuntime().availableProcessors();

    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL);

    CompletableFuture<Player> startQuest(Player player, Quest quest) {
        log.info("{} started the quest: {}", player.getName(), quest.getName());
        CompletableFuture<Player> questFuture = new CompletableFuture<>();

        executorService.schedule(() -> {
            try {
                player.setExperience(player.getExperience() + quest.getReward());
                log.info("{} completes quest: {}. Experience gained: {}",
                        player.getName(), quest.getName(), quest.getReward());
                questFuture.complete(player);
            } catch (Exception e) {
                log.error("Error while processing quest '{}' for player '{}'", quest.getName(), player.getName(), e);
                questFuture.completeExceptionally(e);
            }
        }, quest.getDifficulty(), TimeUnit.SECONDS);
        return questFuture;
    }

    void shutdown() {
        log.info("Shutting down the quest system...");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_TIME_SEC, TimeUnit.SECONDS)) {
                log.warn("Executor did not terminate in {} seconds, forcing shutdown.", TERMINATION_TIME_SEC);
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Shutdown process was interrupted.", e);
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        log.info("Quest system shutdown complete.");
    }

    static void accept(Player player) {
        log.info("{} has completed the quest and now has {} experience points.",
                player.getName(), player.getExperience());
    }
}