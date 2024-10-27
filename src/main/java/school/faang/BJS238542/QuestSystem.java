package school.faang.BJS238542;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest, ExecutorService service) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player.updateExperience(quest.getReward());
            return player;
        }, service).thenApply(result -> {
            log.info(result.getName() + " has completed the quest and now has " + result.getExperience() + " experience points.");
            return result;
        });
    }
}
