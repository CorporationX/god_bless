package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int START_DIFFICULTY_MS = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> completeQuest(player, quest))
                .thenApply(result -> {
                    result.addExperience(quest.getReward());
                    return result;
                });
    }

    public Player completeQuest(Player player, Quest quest) {
        try {
            log.info("{} приступил к прохождению квеста - {}", player.getName(), quest.getName());
            TimeUnit.SECONDS.sleep((long) START_DIFFICULTY_MS * quest.getDifficulty());
            log.info("{} завершил квест", player.getName());
            return player;
        } catch (InterruptedException e) {
            log.error("Поток прерван {}", e.getMessage(), e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
