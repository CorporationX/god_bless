package school.faang.sprint.fourth.wow;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int THREAD_SLEEP_TIME = 1000;
    private final Random random = new Random();
    private final ExecutorService executor;

    public QuestSystem(int threads) {
        validateThreads(threads);
        executor = Executors.newFixedThreadPool(threads);
    }

    public CompletableFuture<Player> startQuest(@NonNull Player player, @NonNull Quest quest) {
        log.info("{} starting quest {}", player.getName(), quest);
        return CompletableFuture.supplyAsync(() -> {
            log.info("Player: {} starting quest: {}", player.getName(), quest.getName());
            try {
                Thread.sleep(random.nextInt(THREAD_SLEEP_TIME));
            } catch (InterruptedException e) {
                log.error("Thread sleep interrupted: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
            player.setExperience(player.getExperience() + quest.getDifficulty());
            return player;
        }, executor).thenApply(currentPlayer -> {
            currentPlayer.setLevel(currentPlayer.getLevel() + 1);
            return currentPlayer;
        });
    }

    public void stopQuests() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted: {}", e.getMessage());
            executor.shutdownNow();
        }
    }

    private void validateThreads(int threads) {
        if (threads <= 0) {
            throw new IllegalArgumentException("Number of threads must be greater than 0");
        }
    }
}
