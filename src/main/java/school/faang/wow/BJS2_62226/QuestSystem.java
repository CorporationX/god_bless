package school.faang.wow.BJS2_62226;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int BASE_QUEST_TIME = 3000;
    private static final int COMPLETION_TIME_OF_TASKS = 1;

    private final ExecutorService threadPool;

    public QuestSystem() {
        this.threadPool = Executors.newCachedThreadPool();
    }

    public CompletableFuture<Player> startQuest(@NonNull Player player, @NonNull Quest quest) {
        CompletableFuture<Player> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.difficulty() + BASE_QUEST_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Задача прервана {}", e.getMessage());
            }

            player.addExperience(quest.reward());
            return player;
        }, threadPool);

        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(COMPLETION_TIME_OF_TASKS, TimeUnit.MINUTES)) {
                log.warn("Принудительное завершение оставшихся задач...");
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Прерывание при ожидании завершения пула потоков {}", e.getMessage());
            threadPool.shutdownNow();
        }

        return future;
    }
}
