package school.faang.bjs2_38824;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.boostExperience(quest.getReward());
            return player;
        });
    }
}
