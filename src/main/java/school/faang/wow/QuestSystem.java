package school.faang.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private static final int MILLIS = 1000;
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName() + " начал квест: " + quest.getName());
                Thread.sleep(quest.getDifficulty() * MILLIS);
                player.addExperience(quest.getReward());
                System.out.println(player.getName() + " завершил квест: " + quest.getName());
                return player;
            } catch (InterruptedException e) {
                throw new IllegalArgumentException(e);
            }
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
