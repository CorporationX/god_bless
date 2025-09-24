package school.faang.bjs2_94449;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Player> playerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) quest.difficulty() * 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.addExperience(quest.reward());
            return player;
        });
        playerCompletableFuture.get();
        return playerCompletableFuture;
    }
}
