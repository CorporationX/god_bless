package school.faang.bjs2_92585;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            return player.addExperience(quest.getReward());
        }, executor);
    }
}
