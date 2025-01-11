package school.faang.sprint4.task_50254;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {


    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            player.addXp(quest.getReward());
            try {
                Thread.sleep(quest.getDifficulty() * MILLIS_IN_SECOND);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            return player;
        });
    }

    private static final long MILLIS_IN_SECOND = 1000;
}
