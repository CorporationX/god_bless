package school.faang.bjs2_92568;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int THREAD_COUNT = 3;
    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(THREAD_COUNT);

    private QuestSystem() {}

    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        int sleepTime = quest.getDifficulty();

        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(sleepTime);
                player.addExperience(quest.getReward());
                player.addLevel(quest.getDifficulty());
                EXECUTOR_SERVICE.shutdown();
            } catch (InterruptedException e) {
                log.info("Прервали во время выполнения квеста");
                Thread.currentThread().interrupt();
            }
            return player;
        }, EXECUTOR_SERVICE);
    }
}