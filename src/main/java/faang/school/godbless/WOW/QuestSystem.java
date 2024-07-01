package faang.school.godbless.WOW;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private static final ExecutorService EXECUTE = Executors.newFixedThreadPool(3);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            log.info(player.getName() + " start quest " + quest.getName());
            try {
                Thread.sleep(player.getLevel() / quest.getDifficulty() * 100L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info(player.getName() + " end quest " + quest.getName());
            return quest.getReward();
        }, EXECUTE).thenApply(result -> {
            player.setExperience(player.getExperience() + result);
            return player;
        });
    }
    public void shutdown() {
        EXECUTE.shutdown();
    }
}