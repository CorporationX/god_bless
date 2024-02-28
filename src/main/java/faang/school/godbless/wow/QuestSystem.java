package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private final ExecutorService EXECUTORSERVICE = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> finishQuest(player, quest), EXECUTORSERVICE);
    }

    private Player finishQuest(Player player, Quest quest) {
        try {
            Thread.sleep(quest.getDifficulty() * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        player.setExperience(player.getExperience() + quest.getReward());
        return player;
    }
}
