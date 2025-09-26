package school.faang.bjs2_94533;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> questFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() + 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Квест был прерван", e);
            }
            player.addExperience(quest.getReward());
            return player;
        });
        return questFuture;
    }
}
