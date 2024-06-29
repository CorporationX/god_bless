package faang.school.godbless.BJS2_13860;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest, ExecutorService threadPool) {
        CompletableFuture<Player> completableFuture = CompletableFuture.supplyAsync(() -> {
            // имитация выполнения квеста
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            player.setExperience(player.getExperience() + quest.getReward());

            return player;
        }, threadPool);

        return completableFuture;
    }
}
