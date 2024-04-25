package faang.school.godbless.bjs2_5896;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Player> futurePlayer = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        }, executorService);
        executorService.shutdown();
        return futurePlayer;
    }
}
