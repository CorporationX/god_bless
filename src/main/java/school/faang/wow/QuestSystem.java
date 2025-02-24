package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final int TWO_SECONDS = 2000;

    CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TWO_SECONDS);
                log.info("Player {} is passed quest {}", player, quest);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread is interrupted", e);
            }
            player.addExperience(quest.getReward());
            return player;
        });
    }
}
