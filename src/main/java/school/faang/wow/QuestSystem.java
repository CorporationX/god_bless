package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName() + " начинает квест: " + quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000);
                player.increaseExperience(quest.getReward());
                System.out.println(player.getName() + " завершил квест: " + quest.getName() + "  и получил " + quest.getReward() + " опыта.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(" Квест был прерван для игрока: " + player.getName());
            }
            return player;
        });
    }
}
