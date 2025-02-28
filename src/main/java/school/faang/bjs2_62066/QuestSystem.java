package school.faang.bjs2_62066;

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
                Thread.currentThread().interrupt();
                log.warn("Quest interrupted", e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }
}
