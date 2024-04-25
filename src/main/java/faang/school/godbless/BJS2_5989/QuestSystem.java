package faang.school.godbless.BJS2_5989;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }
}
