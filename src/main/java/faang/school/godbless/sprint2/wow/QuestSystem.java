package faang.school.godbless.sprint2.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Player> result = CompletableFuture.supplyAsync(() -> {
            log.info("Start quest for: {}", player.getName());
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(quest.getReward());
            return player;
        }, executor);

        executor.shutdown();
        return result;
    }
}
