package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {

    private final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> completeQuest(player, quest), EXECUTOR_SERVICE);
    }

    public void shutdownAndAwaitExecutor(Long minutes) {
        EXECUTOR_SERVICE.shutdown();
        awaitTermination(EXECUTOR_SERVICE, minutes);
    }

    private Player completeQuest(Player player, Quest quest) {
        sleep(3L);
        player.setExperience(player.getExperience() + quest.getReward());
        return player;
    }

    private void awaitTermination(ExecutorService executorService, Long minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void sleep(Long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
