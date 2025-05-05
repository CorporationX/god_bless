package school.faang.bjs2_74719;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int TERMINATION_WAIT_DURATION = 17000;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        log.info("Player {} started the quest {}", player.getName(), quest.name());
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.difficulty() * 1000);
            } catch (InterruptedException e) {
                log.error("Interrupted exception was thrown", e);
            }
            player.addExperience(quest.reward());
            player.tryEarnLevels();
            return player;
        }, executorService);
    }

    public void dispose() {
        log.info("Start disposing executor service");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_WAIT_DURATION, TimeUnit.SECONDS)) {
                log.warn("Not all tasks finished successfully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception was thrown", e);
            executorService.shutdownNow();
        }
    }
}