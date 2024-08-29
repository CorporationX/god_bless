package faang.school.godbless.task.multithreading.async.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private final ExecutorService executor;

    public QuestSystem(int threadPoolSize) {
        this.executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> questPerform(player, quest), executor);
    }

    private Player questPerform(Player player, Quest quest) {
        log.info("{} starts {}", player.getName(), quest);
        sleep(quest.getDifficulty());
        player.addExp(quest.getReward());
        return player;
    }

    private void sleep(int mill) {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
