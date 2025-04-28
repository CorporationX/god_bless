package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        log.debug("Starting quest {} by player {}", quest.getName(), player.getName());
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
                Thread.currentThread().interrupt();
            }
            return player;
            }, ThreadPullSupplier.executor)
                .thenApply(eachPlayer -> {
                    eachPlayer.updateExperience(quest.getReward());
                    return eachPlayer;
                });
    }
}
