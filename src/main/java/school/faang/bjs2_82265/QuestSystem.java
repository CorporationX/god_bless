package school.faang.bjs2_82265;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} is starting quest {}", player.getName(), quest.getName());
                TimeUnit.SECONDS.sleep(quest.getDifficulty());
                player.addExperience(quest.getReward());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Some error while quest {}", quest.getName());
                throw new CompletionException("Error while quest.", e);
            }
            return player;
        }, executorService);
    }
}
