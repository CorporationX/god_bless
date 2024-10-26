package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    final int THREAD_POOL = 5;
    ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL);
    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws InterruptedException {

        return CompletableFuture.supplyAsync(() -> {
            player.addExp(quest.getReward());
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
                executor.shutdown();
            } catch (InterruptedException e) {
                log.error("Начало квеста прервано.");
                throw new RuntimeException(e);
            }
            return player;
        }, executor);
    }
}
