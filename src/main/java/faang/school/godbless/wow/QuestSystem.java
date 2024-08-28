package faang.school.godbless.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        return CompletableFuture.supplyAsync(() -> {
                    log.info("{} started the quest '{}'", player.getName(), quest.getName());
                    try {
                        Thread.sleep(1000L * quest.getDifficulty());
                    } catch (InterruptedException e) {
                        log.error("Quest was interrupted: {}", e.getMessage());
                        throw new RuntimeException(e);
                    }
                    return player;
                }, executorService)
                .thenApplyAsync(p -> {
                    p.addExperience(quest.getReward());
                    log.info("{} completed the quest '{}'", player.getName(), quest.getName());
                    return p;
                }, executorService)
                .exceptionally(throwable -> {
                    log.error("Error completing the quest: {}", throwable.getMessage());
                    return player;
                })
                .whenComplete((result, throwable) -> executorService.shutdownNow());
    }
}