package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Starting quest: " + quest.getName() + " for player: " + player.getName());
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int newExperience = player.getExperience() + quest.getReward();
            player.setExperience(newExperience);
            System.out.println("Quest completed: " + quest.getName() + " for player: " + player.getName());
            return player;
        });
    }
}
