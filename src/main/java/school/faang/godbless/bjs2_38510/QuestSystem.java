package school.faang.godbless.bjs2_38510;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private final ExecutorService pool = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Thread {} : Player {} started quest {}",
                        Thread.currentThread().getName(), player.getName(), quest.getName());
                Thread.sleep(quest.getDifficulty());
                return quest.getReward();
            } catch (InterruptedException e) {
                log.warn("Thread {} interrupted when completing a quest", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
                return 0;
            }
        }, pool).thenApply(exp -> {
            player.addExperience(exp);
            return player;
        });
    }

    public void shutdown() {
        pool.shutdown();
    }
}
