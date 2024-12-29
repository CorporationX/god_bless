package school.faang.sprint4.task50400;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint4.task50400.model.Player;
import school.faang.sprint4.task50400.model.Quest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {

    private static final int THREAD_POOL_SIZE = 10;

    ExecutorService executor;

    public QuestSystem() {
        executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.error("Thread interruption {}", e.getMessage());
                throw new RuntimeException(e);
            }
            player.addExperience(quest.getReward());
            return player;
        }, executor);
    }

    public void finishWork() {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(3, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
