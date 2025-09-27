package school.faang.bjs2_92561;

import lombok.extern.slf4j.Slf4j;

import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int TIME_OUT = 60;
    private static final long EXP_COEFFICIENT = 1000L;

    private final ExecutorService executorService;

    public QuestSystem(int threadPoolSize) {
        executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * EXP_COEFFICIENT);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Quest execution interrupted", e);
            }
            player.addExperience(quest.getReward());
            return player;
        }, executorService);
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                log.error("ExecutorService не завершился корректно");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}