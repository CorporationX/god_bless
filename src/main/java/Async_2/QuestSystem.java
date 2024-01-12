package Async_2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {

    private ExecutorService executor = Executors.newFixedThreadPool(2);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
                player.setExperience(player.getExperience() + quest.getReward());
            } catch (InterruptedException e) {
                System.out.println("Quest is failed");
            }
            return player;
        }, executor);
        return completableFuture;
    }

    public void threadsCloser() {
        executor.shutdown();
    }

}
