package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName() + " has started quest: " + quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000);
                int newExperience = player.getExperience() + quest.getReward();
                player.setExperience(newExperience);
                System.out.println(player.getName() + " completed quest: " + quest.getName() + " and earned " + quest.getReward() + " XP");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return player;
        });
    }
}
