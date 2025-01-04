package school.faang.task_50303;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Player {} started quest: {}", player.getName(), quest.name());
                Thread.sleep(quest.difficulty() * 1000L);
                player.addExperience(quest.reward());
                log.info("Player {} finished quest: {} and get {} experience {}",
                        player.getName(), quest.name(), quest.reward(), player.getExperience());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Quest was interrupted for {}", player.getName());
            }

            return player;
        });
    }
}
