package wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private final ExecutorService questExecutor;
    private final int THREAD_COUNT = 5;

    public QuestSystem() {
        this.questExecutor = Executors.newFixedThreadPool(THREAD_COUNT);
    }

    public ExecutorService getQuestExecutor() {
        return questExecutor;
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficolty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.updateExperience(quest));
            return player;
        },questExecutor);
    }
}

