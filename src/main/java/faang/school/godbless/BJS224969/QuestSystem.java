package faang.school.godbless.BJS224969;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName() + " started quest: " + quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            player.addExperience(quest.getReward());
            return player;
        });
    }
}
