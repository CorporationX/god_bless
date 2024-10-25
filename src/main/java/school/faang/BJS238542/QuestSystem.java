package school.faang.BJS238542;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> taskFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player.updateExperience(quest.getReward());
            return player;
        });
        return taskFuture;
    }
}
