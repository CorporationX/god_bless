package school.faang.BJS2_62214;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final int TIME_THREAD_SLEEP = 100;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> questFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * TIME_THREAD_SLEEP);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.addExperience(quest.getReward());
            return player;
        });
        return questFuture;
    }
}
