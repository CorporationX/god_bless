package faang.school.godbless.BJS224877;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<Player> futurePlayer = CompletableFuture.supplyAsync(() -> {
            try {
                log.info(player.getName() + " started the quest " + quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.error("Quest interrupted : {}", e.getMessage());
                throw new RuntimeException(e);
            }
            return player;
        }, executorService).thenApplyAsync(p -> {
            p.setExperience(player.getExperience() + quest.getDifficulty() + quest.getReward());
            log.info("{} complete the quest {}", player.getName(), quest.getName());
            return p;
        }, executorService).whenComplete((result, throwable) -> executorService.shutdownNow());

        return futurePlayer;
    }
}
