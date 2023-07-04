package faang.school.godbless.sprint4.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws InterruptedException {
        CompletableFuture<Player> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
        return future;
    }
}
