package WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private static final int TIME_QUEST_COMPLETION = 1000;
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep((long) quest.getDifficulty() * TIME_QUEST_COMPLETION);
                    } catch (InterruptedException e) {
                        throw new RuntimeException("class QuestSystem method startQuest, Error", e);
                    }
                }, executor)
                .thenApply(result -> {
                    player.levelUp(quest.getReward());
                    executor.shutdown();
                    return player;
                });
    }
}
