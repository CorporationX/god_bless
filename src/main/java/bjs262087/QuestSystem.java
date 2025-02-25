package bjs262087;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        validate(player, quest);
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(quest.getDifficulty() * 1000L);
                    } catch (InterruptedException e) {
                        log.error("Exception in thread: {}", Thread.currentThread().getId(),
                                new WowException("The process of receiving the quest difficulty " +
                                        "result has been interrupted",
                                        e.getCause()));
                    }
                    player.upgradePlayer(quest);
                    return player;
                }, EXECUTOR_SERVICE);
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
}
