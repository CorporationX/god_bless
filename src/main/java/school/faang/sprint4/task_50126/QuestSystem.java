package school.faang.sprint4.task_50126;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    static CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() ->
        {
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Квест был отменен");
                e.printStackTrace();
                return player;
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }
}
