package school.faang.bjs_50017;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        synchronized (player) {
            return CompletableFuture.supplyAsync(() -> {
                log.info("{} starting quest {}", player.getName(), quest.getName());
                return updatePlayer(player, quest);
            }).thenApply(p -> {
                log.info("Quest {} is running", quest.getName());
                try {
                    Thread.sleep(quest.getDifficulty());
                } catch (InterruptedException e) {
                    log.error("Quest {} interrupted", quest.getName());
                    Thread.currentThread().interrupt();
                }
                log.info("Quest {} is finished", quest.getName());
                return p;
            });
        }

    }

    public Player updatePlayer(Player player, Quest quest) {
        player.setExperience(player.getExperience() + quest.getReward());
        return player;
    }
}
