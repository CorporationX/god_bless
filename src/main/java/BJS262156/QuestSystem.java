package BJS262156;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final int DIFFICULTY_IN_MS = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> questFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) quest.getDifficulty() * DIFFICULTY_IN_MS);
            } catch (InterruptedException e) {
                log.error("Problem in method startQuest ", e);
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
        return questFuture;
    }
}
