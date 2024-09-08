package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }
}
