package school.faang.sprint4.task63880;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final int FACTOR = 1_000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * FACTOR);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("\n[{}] [{}] was interrupted.", System.currentTimeMillis(),
                        Thread.currentThread().getName());
            }
            player.addExperience(quest.getReward());
            return player;
        });
        return completableFuture;
    }
}
