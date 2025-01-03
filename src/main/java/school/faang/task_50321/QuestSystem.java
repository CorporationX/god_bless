package school.faang.task_50321;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                player.setExperience(player.getExperience() + quest.getReward());
                Thread.sleep(quest.getDifficulty() * 1000L);
                return player;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
