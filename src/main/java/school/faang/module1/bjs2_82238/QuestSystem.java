package school.faang.module1.bjs2_82238;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    private static final long MILLIS_PER_SECOND = 1000L;

    CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("{} начал задание: {}", player.getName(), quest.getName());
            try {
                Thread.sleep(quest.getDifficulty() * MILLIS_PER_SECOND);
                player.updateExperience(quest.getReward());
                log.info("{} завершил задание: {}", player.getName(), quest.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return player;
        });
    }
}