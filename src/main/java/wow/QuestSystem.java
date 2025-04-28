package wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int MILLISECONDS_PER_SECOND = 1000;

    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep((long) quest.getDifficulty() * MILLISECONDS_PER_SECOND);
                    } catch (InterruptedException e) {
                        log.error("An error occurred while completing quest {}: {}",
                                quest.getName(), e.getMessage());
                        Thread.currentThread().interrupt();
                        throw new QuestExecutionException("an error occurred while waiting" +
                                " for the quest to complete.", e);
                    }
                    synchronized (player) {
                        player.addExperience(quest.getReward());
                    }
                    return player;
                });
    }
}
