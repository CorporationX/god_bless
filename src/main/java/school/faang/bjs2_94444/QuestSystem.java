package school.faang.bjs2_94444;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class QuestSystem {
    private static final int DEFAULT_TIME_TO_QUEST = 1000;
    private static final double LEVEL_QUEST = 1.5;
    private static final int TIME_AWAIT_MINUTE = 1;
    private final ExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        int timeQuest = DEFAULT_TIME_TO_QUEST * quest.getDifficulty();
        return CompletableFuture.supplyAsync(() -> {
            AtomicInteger experience = new AtomicInteger();
            try {
                log.info("{} Начал квест {} - сложностью {}",
                        player.getName(), quest.getName(), quest.getDifficulty());
                Thread.sleep(timeQuest);
                log.info("{} - Завершил квест {}!, {} - сложностью и получает за квест {} - опыта!",
                        player.getName(), quest.getName(), quest.getDifficulty(), quest.getReward());
                experience.addAndGet((int) Math.round(LEVEL_QUEST * quest.getDifficulty()));
            } catch (InterruptedException e) {
                log.error("Ошибка в имитации выполнения квеста");
            }
            return player.addExperience(experience);
        }, executor);
    }

    public void gracefullyShutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_AWAIT_MINUTE, TimeUnit.MINUTES)) {
                log.info("Потоки не остановились за {} минут. Останавливаем потоки", TIME_AWAIT_MINUTE);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка при остановке потоков");
        }
    }
}
