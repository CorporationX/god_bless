package school.faang.bjs2_92574;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1_000);

                int newExp = player.getExperience() + quest.getReward();
                player.setExperience(newExp);

                return player;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Квест был прерван!", e);
            }
        });
    }
}
