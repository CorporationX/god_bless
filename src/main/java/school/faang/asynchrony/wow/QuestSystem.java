package school.faang.asynchrony.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private final int CONSTANT_THREAD_TIME = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * CONSTANT_THREAD_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player.addEx(quest.getReward());
            return player;
        });
        return result;
    }

}
