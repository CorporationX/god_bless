package bjs262087;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final long THREAD_SLEEP_IN_MS = 1000;
    private static final long AWAIT_TERMINATION_IN_MS = 10000;
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        validate(player, quest);
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(quest.getDifficulty() * THREAD_SLEEP_IN_MS);
                    } catch (InterruptedException e) {
                        log.error("Thread {} interrupted", Thread.currentThread().getId(),
                                new WowException("The process of receiving the quest difficulty " +
                                        "result has been interrupted"));
                        Thread.currentThread().interrupt();
                    }
                    player.upgradePlayer(quest);
                    return player;
                }, executorService);
    }

    private void validate(@NonNull Player player, @NonNull Quest quest) {
        if (Objects.isNull(player.getName()) || player.getName().isEmpty()) {
            log.error("Thread {}", Thread.currentThread().getId(),
                    new WowException("Player`s name should not be null or empty", new IllegalArgumentException()));
        }
        if (Objects.isNull(quest.getName()) || quest.getName().isEmpty()) {
            log.error("Thread {}", Thread.currentThread().getId(),
                    new WowException("Quest`s name should not be null or empty", new IllegalArgumentException()));
        }
    }

    public void shutDownExecutorService() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_IN_MS, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
