package sprint_4.sprint_4_1_async_future.wow_38551;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int COUNT_THREADS_POOL = 2;
    private static final int WAIT_TIME_TERMINATION = 50;
    private static final long ONE_TIME = 1000;

    private final ExecutorService executor;

    public QuestSystem() {
        this.executor = Executors.newFixedThreadPool(COUNT_THREADS_POOL);
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Quest start: {}", quest.getName());
            sleepThread(quest.getDifficulty() * ONE_TIME);
            player.setExperience(player.getExperience() + quest.getReward());
            log.info("Quest finish: {}.", quest.getName());
            return player;
        }, executor);
    }

    private void sleepThread(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Thread is dead");
        }
    }

    public void shutdown() {
        this.executor.shutdown();
        try {
            if (!this.executor.awaitTermination(WAIT_TIME_TERMINATION, TimeUnit.SECONDS)) {
                this.executor.shutdownNow();
                log.warn("Executor did not terminate in the specified time: {} seconds", "WAIT_TIME_TERMINATION");
            }
        } catch (InterruptedException e) {
            this.executor.shutdownNow();
            log.warn("Executor interrupted during termination.");
        }
    }
}
