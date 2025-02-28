package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    private static final long DIFFICULTY_COEFFICIENT = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * DIFFICULTY_COEFFICIENT);
                player.addExperience(quest.getReward());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток прерван во время выполнения квеста", e);
            }
            return player;
        });
    }
}
