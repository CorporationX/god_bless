package faang.school.godbless.BJS2_25097;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private final ExecutorService executor = Executors.newFixedThreadPool(4); // Create a custom thread pool

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> updatedPlayer = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        }, executor);

        return updatedPlayer;
    }

    public void shutdown() {
        executor.shutdown();
    }

}
