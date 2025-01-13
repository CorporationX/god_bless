package wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {
    ExecutorService executorService;

    public QuestSystem(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public CompletableFuture<Player> startQuest(Quest quest, Player player) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        }, executorService);
    }
}
