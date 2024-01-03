package faang.school.godbless.BJS2_1323;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private final ExecutorService executorService;

    public QuestSystem() {
        this.executorService = Executors.newFixedThreadPool(2);
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            int difficulty = quest.getDifficulty();
            int newExp = difficulty + player.getExperience();
            try {
                Thread.sleep(difficulty * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(newExp);
            return player;
        }, executorService);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}