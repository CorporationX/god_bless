package school.faang.bjs2_92621;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (player) {
                try {
                    System.out.printf("%s started quest %s%n", player.getName(), quest.getName());
                    Thread.sleep(quest.getDifficulty() * 1000L);
                    player.setExperience(player.getExperience() + quest.getReward());
                } catch (InterruptedException e) {
                    throw new RuntimeException("Something went wrong during the quest: " + e);
                }
                System.out.printf("%s completed quest %s and earned %d experience points%n",
                        player.getName(), quest.getName(), quest.getReward());
                return player;
            }
        });
    }
}