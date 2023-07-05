package Multithreading.bc3053_WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Player> result = CompletableFuture.supplyAsync(() -> {
            int reward = quest.getReward();
            try {
                Thread.sleep(reward * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + reward);
            return player;
        });
        executorService.shutdown();

        return result;
    }
}
