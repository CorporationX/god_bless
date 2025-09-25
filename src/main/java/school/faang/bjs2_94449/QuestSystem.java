package school.faang.bjs2_94449;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private static final int GET_MILLIS = 100;
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public CompletableFuture<Player> startQuest(Player player, Quest quest)
            throws ExecutionException, InterruptedException {
        CompletableFuture<Player> playerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) quest.difficulty() * GET_MILLIS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.addExperience(quest.reward());
            return player;
        }, executorService);
        playerCompletableFuture.get();
        return playerCompletableFuture;
    }
}
