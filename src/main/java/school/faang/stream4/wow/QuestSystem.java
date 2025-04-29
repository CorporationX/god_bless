package school.faang.stream4.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    public static final int THREAD_COUNT = 2;
    public static final int TERMINATION_TIMEOUT = 30;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            log.info("Player {} start performing quest {}", player.getName(), quest.name());
            delayQuestPerformance(quest);
            player.increaseExperience(quest.reward());
            log.info("Player {} finished his quest {} and got reward", player.getName(), quest.name());
            return player;
        }, executorService);
    }

    private void delayQuestPerformance(Quest quest) {
        long millisToWait = 1000L * quest.difficulty();
        try {
            Thread.sleep(millisToWait);
        } catch (InterruptedException e) {
            log.error("Interruption during delay {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        this.executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
