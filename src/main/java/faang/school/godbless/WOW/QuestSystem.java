package faang.school.godbless.WOW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> future = CompletableFuture.supplyAsync(() -> {
            player.setExperience(player.getExperience() + quest.getReward());
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player;
        });
        return future;
    }
}
