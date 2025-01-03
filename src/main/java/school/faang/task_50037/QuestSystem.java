package school.faang.task_50037;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final long MILLISECONDS_MULTIPLIER = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * MILLISECONDS_MULTIPLIER);
            } catch (InterruptedException e) {
                log.warn("Thread was interrupted", e);
                Thread.currentThread().interrupt();
            }
            int updatedExperience = player.getExperience() + quest.getReward();
            player.setExperience(updatedExperience);
            return player;
        });
    }
}
