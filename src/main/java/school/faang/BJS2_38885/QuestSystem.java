package school.faang.BJS2_38885;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private final ExecutorService questExecutor;

    public QuestSystem(int poolSize) {
        this.questExecutor = Executors.newFixedThreadPool(poolSize);
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
                synchronized (player) {
                    player.addExperience(quest.getReward());
                }
                System.out.println(player.getName() +
                    " has completed the quest \"" +
                    quest.getName() +
                    "\" and now has " +
                    quest.getReward() +
                    " experience points.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return player;
        }, questExecutor);
    }

    public void shutdown() {
        questExecutor.shutdown();
    }
}
