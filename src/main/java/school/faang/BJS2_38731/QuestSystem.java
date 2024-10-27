package school.faang.BJS2_38731;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName() + "start quest  " + quest.getName());

                Thread.sleep(quest.getDifficulty() * 1000L);

                player.addExperience(quest.getReward());
                System.out.println(player.getName() + " quest completed " + quest.getName() + " and got " + quest.getReward() + " exp ");
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            return player;
        });
    }
}
