package school.faang.wow82282;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final Long MULTIPLIER_FOR_SLEEP = 1000L;
    private static final long MAX_WAIT_TIME = 10;

    private static final Object lock = new Object();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws InterruptedException {

        return CompletableFuture.supplyAsync(() -> {
            try {
                synchronized (lock) {
                    Thread.sleep(quest.getDifficulty() * MULTIPLIER_FOR_SLEEP);
                    player.addExpirience(quest.getReward());
                    System.out.printf("квест %s выполнен%n", quest.getName());
                }
            } catch (InterruptedException e) {
                log.error("Поток {} был прерван", Thread.currentThread().getName(), e);
                Thread.currentThread().interrupt();
            }
            return player;
        });
    }

    public static void gracefulShutdown(ExecutorService questExecutor) {
        questExecutor.shutdown();
        try {
            if (!questExecutor.awaitTermination(MAX_WAIT_TIME, TimeUnit.SECONDS)) {
                questExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            questExecutor.shutdownNow();
        }
    }
}
