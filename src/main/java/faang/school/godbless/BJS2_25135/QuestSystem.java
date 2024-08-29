package faang.school.godbless.BJS2_25135;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
       return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                System.out.printf("%s was interrupted\n", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
            player.setLevel(player.getLevel() + 1);
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }
}