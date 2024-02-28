package wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> questFuture = CompletableFuture.supplyAsync(() -> {
            try {
                if (quest.getDifficulty().equals("Easy")) {
                    Thread.sleep(5000);
                } else {
                    Thread.sleep(10000);
                }

                int newExperience = player.getExperience() + quest.getReward();
                player.setExperience(newExperience);

                if (newExperience >= 500) {
                    int newLevel = player.getLevel() + 1;
                    player.setLevel(newLevel);
                    player.setExperience(newExperience - 500);
                    System.out.println(player.getName() + " has leveled up to " + player.getLevel());
                }

                return player;
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        });

        return questFuture;
    }
}
