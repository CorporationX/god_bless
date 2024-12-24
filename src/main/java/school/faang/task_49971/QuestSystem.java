package school.faang.task_49971;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class QuestSystem {
    private static final long MILLIS = 1000L;

    CompletableFuture<Player> startQuest(Player player,
                                         Quest quest,
                                         ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * MILLIS);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            player.addExperience(quest.getReward());
            return player;
        }, executor);
    }
}
