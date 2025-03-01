package school.faang.BJS2_62096;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final int MILLISECONDS_IN_SECOND = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        if (player == null || quest == null) {
            throw new IllegalArgumentException("Player и  Quest не могут быть null");
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} Начал {} квест", player.getName(), quest.getName());
                Thread.sleep((long) quest.getDifficulty() * MILLISECONDS_IN_SECOND);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток был прерван во время выполнения квеста", e);
                throw new RuntimeException("Поток был прерван", e);
            }
            player.addExperience(quest.getReward());
            return player;
        });
    }
}