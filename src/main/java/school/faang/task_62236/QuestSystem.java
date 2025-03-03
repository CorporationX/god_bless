package school.faang.task_62236;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class QuestSystem {
    private static final int SHUTDOWN_TIMEOUT_SECONDS = 5;

    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("{} is starting the quest: {}", player.getName(), quest.name());
            try {
                TimeUnit.SECONDS.sleep(quest.difficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Quest interrupted for player {}: {}", player.getName(), quest.name(), e);
                throw new RuntimeException("Quest interrupted", e);
            }
            player.addExperience(quest.reward());
            log.info("{} has completed the quest: {}", player.getName(), quest.name());
            return player;
        }, executor);
    }

    public void processQuestResult(CompletableFuture<Player> questFuture) {
        questFuture.thenAccept(player ->
                log.info("{} now has {} experience points.", player.getName(), player.getExperience()));
    }

    public void shutdown() {
        log.info("Shutting down QuestSystem...");
        executor.shutdown();
        try {
            if (!executor.awaitTermination(SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                if (!executor.awaitTermination(SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                    log.error("Executor did not terminate cleanly");
                }
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        log.info("QuestSystem shut down successfully.");
    }
}
