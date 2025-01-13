package school.faang.task_50225;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName() + " is starting the quest: " + quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000L);
                player.addExperience(quest.getReward());
                System.out.println(player.getName() + " has completed the quest: " + quest.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return player;
        });
    }
}
