package school.faang.task62302;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final Object LOCK = new Object();
    private static final long QUEST_TIME_MS = 1000;

    public CompletableFuture<Player> startQuest(@NonNull Player player, @NonNull Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} start quest {}", player.getName(), quest.getName());
                Thread.sleep(quest.getDifficulty() * QUEST_TIME_MS);
                return quest.getReward();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Step start quest. Error thread sleep. Forced termination: {}", e.getMessage());
                throw new RuntimeException(e);
            }
        })
                .thenApply(reward -> {
                    synchronized (LOCK) {
                        log.info("Complete quest, add exp for {}", player.getName());
                        player.setExperience(player.getExperience() + quest.getReward());
                        return player;
                    }
                });
    }
}
