package school.faang.multithreading.async.bjs2_92551;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final long ONE_SECOND_DELAY = 1000;
    private static final long MAX_WAIT_TIME = 2;
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
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
                }, executor); // Не хочет работать с executor

        gracefullyShutdown();

        return future;
    }

    public void gracefullyShutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_WAIT_TIME, TimeUnit.MINUTES)) {
                log.warn("Не все задачи завершились вовремя, принудительно закрываем пул потоков...");
                executor.shutdownNow();
            } else {
                log.info("Все задачи выполнены успешно.");
            }
        } catch (InterruptedException e) {
            log.error("Главный поток был прерван.");
            executor.shutdownNow();
        }
    }
}
