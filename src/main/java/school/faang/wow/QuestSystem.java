package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> futurePlayer = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(quest.getDifficulty());
                synchronized (player) {
                    player.setExperience(player.getExperience() + quest.getReward());
                }
                return player;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Произошла ошибка: {}", e.getMessage());
                throw new RuntimeException(e);
            }
        });
        return futurePlayer;
    }
}
