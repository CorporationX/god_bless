package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int TIME_EASY_QUEST = 2;
    private static final int TIME_NORMAL_QUEST = 4;
    private static final int TIME_HARD_QUEST = 10;
    private static final int TIME_LEGEND_QUEST = 20;
    private static final int TIME_WAITING_THREADS = 25;
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        log.info("Выполнение квеста игроком {}", player.getName());
        return CompletableFuture.supplyAsync(() -> {
            simulationQuest(quest);
            player.addExperience(quest.getReward());
            return player;
        }, executor);
    }

    private void simulationQuest(Quest quest) {
        try {
            switch (quest.getDifficulty()) {
                case EASY -> TimeUnit.SECONDS.sleep(TIME_EASY_QUEST);
                case NORMAL -> TimeUnit.SECONDS.sleep(TIME_NORMAL_QUEST);
                case HARD -> TimeUnit.SECONDS.sleep(TIME_HARD_QUEST);
                case LEGEND -> TimeUnit.SECONDS.sleep(TIME_LEGEND_QUEST);
                default -> log.info("У квеста отсутствует сложность");
            }
        } catch (InterruptedException e) {
            log.warn("Поток прерван", e);
        }
    }

    public void terminatedExecutor() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_WAITING_THREADS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
            log.info("Пул потоков остановлен");
        } catch (InterruptedException e) {
            log.error("Поток прерван", e);
            Thread.currentThread().interrupt();
        }
    }
}