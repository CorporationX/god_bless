package school.faang.multithreading.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Player " + player.getName() + " starting quest " + quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000);
                player.updateExperience(quest.getReward());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player;
        });
    }
}
