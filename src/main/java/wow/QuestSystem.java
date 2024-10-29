package wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new IllegalArgumentException("Ошибка при вызове метода sleep().");
            }
            player.addExperience(quest.getReward());
            return player;
        });
    }
}
