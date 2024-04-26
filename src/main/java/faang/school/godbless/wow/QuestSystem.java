package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName() + " has started the quest: " + quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000); // Имитация выполнения задания
                player.setExperience(player.getExperience() + quest.getReward());
                System.out.println(player.getName() + " has completed the quest: " + quest.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return player;
        });
    }
}