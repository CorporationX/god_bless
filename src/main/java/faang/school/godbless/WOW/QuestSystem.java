package faang.school.godbless.WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<Player> playerFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Player " + player.getName() + " started quest " + quest.getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Player: " + player.getName() + " interrupted in quest: " + quest.getName());
            }
            player.setExperience(player.getExperience() + quest.getReward() * quest.getDifficulty());
            return player;
        }, executorService);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        return playerFuture;
    }
}
