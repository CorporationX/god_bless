package school.faang.sprint4_future_async.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final long FIX_RATE = 100L;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MICROSECONDS.sleep(quest.getDifficulty() * FIX_RATE);
            } catch (InterruptedException e) {
                log.error("ОШIБКА прерывания во время выполнения сна!!!", e);
            }
            player.addExperience(quest.getReward());
            return player;
        }, EXECUTOR);
    }

    public void executorShutdown() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(2, TimeUnit.MINUTES)) {
                log.error("Задача не завершилась за 2 мин, принудительно останавливаем...");
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Главный поток был прерван во время ожидания, принудительно останавливаем пул...");
            EXECUTOR.shutdownNow();
        }
    }
}