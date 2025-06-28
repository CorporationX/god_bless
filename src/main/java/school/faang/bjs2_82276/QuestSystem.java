package school.faang.bjs2_82276;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
                log.info("QuestSystem startQuest " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            player.addExperience(quest.getReward());
            return player;
        });
    }
}
