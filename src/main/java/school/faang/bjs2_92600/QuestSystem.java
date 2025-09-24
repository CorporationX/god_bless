package school.faang.bjs2_92600;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int COEFFICIENT_TIME = 100;
    private static final int COEFFICIENT_EXPERIENCE = 10;
    private static final int NUM_THREADS = 5;
    private static final int TEN_SECONDS_IN_MS = 10000;
    private final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) quest.getDifficulty() * COEFFICIENT_TIME);
                synchronized (player) {
                    player.setExperience(player.getExperience() + COEFFICIENT_EXPERIENCE * quest.getDifficulty());
                    log.info("Игрок {} выполнил квест {} и получил в награду {} золотых",
                            player.getName(),
                            quest.getName(),
                            quest.getReward());
                }
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
            return player;
        }, executorService);
    }

    public void shutdownCorrectly() {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TEN_SECONDS_IN_MS, TimeUnit.MILLISECONDS)) {
                log.info("Все задачи выполнены");
            } else {
                log.info("Задачи не успели выполниться");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info(e.getMessage());
            executorService.shutdownNow();
        }
    }
}
