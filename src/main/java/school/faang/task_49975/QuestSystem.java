package school.faang.task_49975;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.error("Error during quest execution: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
            player.addExperience(quest.getReward());
            return player;
        });
    }
}
