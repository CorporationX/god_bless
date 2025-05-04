package school.faang.bjs274611;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private static final int DIFFICULTY_TIME = 1000;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
    private static final int THREAD_COUNT = 2;

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * DIFFICULTY_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Квест был прерван");
                return player;
            }
            player.addExperience(quest.getReward());
            return player;
        }, executorService);
    }
}

