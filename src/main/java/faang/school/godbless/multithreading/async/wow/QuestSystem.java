package faang.school.godbless.multithreading.async.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted in quest", e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        }, executor);
    }
}
