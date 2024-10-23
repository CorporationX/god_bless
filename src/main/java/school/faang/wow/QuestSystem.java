package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван " + e.getMessage());
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }
}
