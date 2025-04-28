package wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(quest.getDifficulty() * 1000);
                    } catch (InterruptedException e) {
                        log.error("An error occurred while completing quest {}: {}",
                                quest.getName(), e.getMessage());
                        Thread.currentThread().interrupt();
                        throw new QuestExecutionException("an error occurred while waiting" +
                                " for the quest to complete.", e);
                    }
                    player.addExperience(quest.getReward());
                    return player;
                });
    }
}
