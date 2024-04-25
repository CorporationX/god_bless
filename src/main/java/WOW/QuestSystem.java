package WOW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(player.getName() + " начинает квест " + quest.getName());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
            System.out.println(player.getName() + " заканчивает квест!");

            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }
}
