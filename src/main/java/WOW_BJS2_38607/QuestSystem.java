package WOW_BJS2_38607;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            player.getReward(quest.getReward());
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return player;
        }, executor);
    }
}