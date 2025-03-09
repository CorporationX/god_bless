package school.faang;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public static CompletableFuture<Player> startQuest(Player player, Quest quest) throws Exception {
        CompletableFuture<Player> playerFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(quest.getReward());
            return player;
        });
        return playerFuture;
    }
}
