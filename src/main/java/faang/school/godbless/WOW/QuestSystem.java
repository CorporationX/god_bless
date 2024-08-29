package faang.school.godbless.WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private ExecutorService executorService = Executors.newCachedThreadPool();
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> completableFuture = new CompletableFuture<>();

        executorService.submit(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 500);
                player.setExperience(player.getExperience() + quest.getReward());
            } finally {
                executorService.shutdown();
            }
            completableFuture.complete(player);
            return null;
        });
        return completableFuture;
    }
}
