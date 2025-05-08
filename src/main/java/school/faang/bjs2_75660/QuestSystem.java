package school.faang.bjs2_75660;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int THREAD_COUNT = 5;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (IllegalStateException | InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Поток был прерван. ERROR ", e);
            }
            player.getExperience().addAndGet(quest.getReward());
            return player;
        }, executor);
    }

    public void shutDown() {
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
