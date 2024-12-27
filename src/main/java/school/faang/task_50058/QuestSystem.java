package school.faang.task_50058;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                CompletableFuture.completedFuture(null);
            }
            player.addExperience(quest.getReward());
            return player;

        });
    }
}
