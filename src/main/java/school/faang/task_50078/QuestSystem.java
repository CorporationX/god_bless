package school.faang.task_50078;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName() + " started the quest: " + quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            player.addExperience(quest.getReward());
            System.out.println(player.getName() + " completed the quest: " + quest.getName());
            return player;
        });
    }
}