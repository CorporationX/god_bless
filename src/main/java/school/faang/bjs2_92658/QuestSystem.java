package school.faang.bjs2_92658;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {


    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3_000L * quest.getDifficulty());
            } catch (InterruptedException e) {
                log.error("Quest delayed interrupted: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
            player.addExp(quest.getReward());
            return player;
        });
    }
}
