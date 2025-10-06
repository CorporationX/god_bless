package school.faang.bjs2_92658;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final long BASIC_QUEST_TIME_MS = 3_000;
    private static final int AWAIT_TIME_SECONDS = 10;

    private final ExecutorService ex = Executors.newFixedThreadPool(4);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        log.info("{} has started '{}' (difficulty: {}, reward: {})",
                player.getName(), quest.getName(), quest.getDifficulty(), quest.getReward());
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(BASIC_QUEST_TIME_MS * quest.getDifficulty());
            } catch (InterruptedException e) {
                log.error("Quest {} delayed interrupted: {}", quest.getName(), e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException();
            }
            player.addExp(quest.getReward());
            log.info("{} has completed '{}' and got {} experience. Current level: {}, Total experience: {}",
                    player.getName(), quest.getName(), quest.getReward(), player.getLevel(), player.getExperience());
            return player;
        }, ex);
    }

    public void executorsShutdown() {
        ex.shutdown();

        try {
            if (!ex.awaitTermination(AWAIT_TIME_SECONDS, TimeUnit.SECONDS)) {
                log.error("Executor didn't terminate in time, shutting down");
                ex.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Shutdown interrupted: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
