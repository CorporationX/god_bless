package school.faang.multithreading.async.bjs2_92551;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private static final long ONE_SECOND_DELAY = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture<Player> future =
                CompletableFuture.supplyAsync(() -> {
                    log.info("{} начинает выполнять квест {} ", player.getName(), quest.name());
                    try {
                        Thread.sleep(ONE_SECOND_DELAY * quest.difficulty());
                        log.info("Квест '{}' выполнен", quest.name());
                        player.updateExperience(quest.reward());
                    } catch (InterruptedException e) {
                        throw new IllegalStateException("Выполнение квеста " + quest.name() + " прервано", e);
                    }
                    return player;
                }, executor);

        executor.shutdown();

        return future;
    }
}
