package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws InterruptedException {
        Thread.sleep(quest.getDifficulty() * 1000L);
        return CompletableFuture.supplyAsync(() -> {
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }

    public void printResults(Player player) {
        System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points.");
    }
}
