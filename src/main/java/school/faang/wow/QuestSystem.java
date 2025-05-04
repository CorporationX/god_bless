package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
                player.setExperience(player.getExperience() + quest.getReward());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return player;
        });
    }
}
