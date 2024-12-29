package school.faang.bjs250369;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted during quest execution: " + e.getMessage());
                return null;
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
        return completableFuture;
    }

}
