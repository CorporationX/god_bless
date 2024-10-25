package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws InterruptedException {
        Thread.sleep(quest.getDifficulty() * 1000L);
        return CompletableFuture.supplyAsync(() -> {
                    player.addExp(quest.getReward());
                    return player;});
    }
}
