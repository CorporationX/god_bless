package mod1sp4.bjs2_38616_wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Starting quest {}", quest);
            long levelTimeoutByDifficulty = quest.getDifficulty() * 1000L;
            try {
                Thread.sleep(levelTimeoutByDifficulty);
            } catch (InterruptedException e) {
                log.error("Quest interrupted", e);
                throw new IllegalStateException(e);
            }
            player.addExperience(player.getExperience() + quest.getReward());
            return player;
        }, executor);
    }

    public void shutdownExecutor() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Executor shutdown interrupted", e);
            throw new IllegalStateException(e);
        }
    }
}
