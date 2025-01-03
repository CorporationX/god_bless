package school.faang.task_50174;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("player " + player.getName() + " is starting the quest " + quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000);
                player.addExp(quest);
                System.out.println("Player " + player.getName() + " completed the quest: " + quest.getName());
                return player;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Quest execution was interrupted for player: " + player.getName(), e);
            }
        });
    }
}
