package school.faang.bjs2_92542;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
                int experience = player.getExperience() + quest.getReward();
                player.setExperience(experience);
                return player;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Quest has been interrupted.");
            }
        });
        future.join();
        return future;
    }
}
