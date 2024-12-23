package school.faang.task_49990;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final long SLEEP_TIME = 1000L;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(quest.getDifficult() * SLEEP_TIME);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return quest.getReward();
                })
                .thenApply((reward) -> {
                    player.setExperience(player.getExperience() + reward);
                    return player;
                });
    }
}
