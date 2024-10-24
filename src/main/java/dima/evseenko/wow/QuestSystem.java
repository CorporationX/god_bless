package dima.evseenko.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        if (executor.isShutdown()) {
            executor = Executors.newCachedThreadPool();
        }

        CompletableFuture<Player> future = CompletableFuture.supplyAsync(() -> {
            try {
                player.setExperience(player.getExperience() + quest.getReward());
                Thread.sleep(quest.getDifficulty().getQuestCompleteTime());
                return player;
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new IllegalStateException("Ошибка при выполнении квеста %s игроком %s!".formatted(quest.getName(), player.getName()), e);
            }
        }, executor);

        executor.shutdown();

        return future;
    }
}
