package school.faang.bjs2_94444;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int DEFAULT_TIME_TO_QUEST = 1000;
    private static final double LEVEL_QUEST = 1.5;
    private static final int TIME_AWAIT_MINUTE = 1;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        int timeQuest = DEFAULT_TIME_TO_QUEST * quest.getDifficulty();
        CompletableFuture<Player> future = CompletableFuture.supplyAsync(() -> {
            double experience = 0;
            try {
                log.info("{} Начал квест {} - сложностью {}",
                        player.getName(), quest.getName(), quest.getDifficulty());
                Thread.sleep(timeQuest);
                log.info("{} - Завершил квест {}!, {} - сложностью и получает за квест {} - опыта!",
                        player.getName(), quest.getName(), quest.getDifficulty(), quest.getReward());
                experience = (int) Math.round(LEVEL_QUEST * quest.getDifficulty());
            } catch (InterruptedException e) {
                log.error("Ошибка в имитации выполнения квеста");
            }
            return player.addExperience(experience);
        }, executor);
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
        return future;
    }
}
