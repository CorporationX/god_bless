package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> questFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Ошибка при выполнении квеста у " + player.getName());
                throw new RuntimeException(e.getMessage());
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
        return questFuture;
    }
}
