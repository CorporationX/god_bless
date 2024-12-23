package school.faang.task_49971;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {
    CompletableFuture<Player> startQuest(Player player,
                                         Quest quest,
                                         ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() + 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
            player.addExperience(quest.getReward());
            return player;
        }, executor);
    }
}
