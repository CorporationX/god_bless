package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                log.info(e.getMessage(), e);
                Thread.currentThread().interrupt();
            }
            player.addExperience(quest.getReward());
            return player;
        });
    }
}
