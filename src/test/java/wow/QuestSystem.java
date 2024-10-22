package wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficolty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.updateExperience(quest));
            return player;
        });
    }
}

