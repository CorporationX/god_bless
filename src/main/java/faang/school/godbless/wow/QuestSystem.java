package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws InterruptedException {
        Thread.sleep(quest.getDifficulty());
        return CompletableFuture.supplyAsync(() -> player)
                .thenApplyAsync(player1 -> {
                    player1.setExperience(quest.getReward());
                    return player1;
                });
    }
}
