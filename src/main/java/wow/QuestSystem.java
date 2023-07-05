package wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        return CompletableFuture.runAsync(() -> {
                    System.out.println("Starting quest " + quest.getName() + " | Difficulty of the quest - " + quest.getDifficulty());
                    doQuest(quest.getDifficulty());
                    System.out.println("\nQuest completed: " + quest.getName());
                }, executorService)
                .thenApply((Void) -> {
                    player.increaseExperience(quest.getReward());
                    player.increaseLevel();
                    return player;
                });
    }

    private void doQuest(int difficultyOfQuest) {
        try {
            TimeUnit.SECONDS.sleep(difficultyOfQuest);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
