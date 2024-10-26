package school.faang.BJS2_38885;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
                player.addExperience(quest.getReward());
                System.out.println(player.getName() +
                    " has completed the quest \"" +
                    quest.getName() +
                    "\" and now has " +
                    quest.getReward() +
                    " experience points.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return player;
        });
    }
}
