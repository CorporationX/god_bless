package school.faang.wow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    private static final int THREAD_POOL_COUNT = 3;
    private static final int THREAD_SLEEP = 3000;
    private static final int TIMEOUT = 30;
    private static final Logger log = LoggerFactory.getLogger(QuestSystem.class);
    private final ExecutorService executorService;

    public QuestSystem() {
        this.executorService = Executors.newFixedThreadPool(THREAD_POOL_COUNT);
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        System.out.println("Начинается квест: " + quest.getName());

        try {
            Thread.sleep(THREAD_SLEEP);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Thread interrupted. Details: {}", e.getMessage());
        }

        return CompletableFuture.supplyAsync(() -> {
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        }, executorService);
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted while waiting for executor service termination: ", e);
        }
    }
}
