package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final int SLEEP_TIME = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * SLEEP_TIME);
                player.addExperience(quest.getReward());
                return player;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Quest execution interrupted", e);
            }
        });
    }
}
