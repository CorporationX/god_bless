package school.faang.multithreading.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> runningQuest(player, quest), executorService);
    }

    private Player runningQuest(Player player, Quest quest) {
        try {
            Thread.sleep(quest.getDifficulty() * 1000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Поток прерван до или во время выполнения", e);
        }
        player.setLevel(player.getLevel() + 1);
        player.setExperience(player.getExperience() + quest.getReward());

        return player;
    }
}
