package BJS2_24914_WorldOfWarcraft;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Player> updatedPlayer = CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} started quest {}", player.getName(), quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000L);
                player.setExperience(player.getExperience() + quest.getReward());
            } catch (InterruptedException e) {
                log.error("Thread was interrupted!", e);
            }
            return player;
        }, executor);
        executor.shutdown();
        return updatedPlayer;
    }
}
