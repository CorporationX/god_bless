package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final int START_DIFFICULTY = 1000;

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
            Thread.sleep((long) START_DIFFICULTY * quest.getDifficulty());
            log.info("{} завершил квест", player.getName());
            return player;
        } catch (InterruptedException e) {
            log.error("Поток прерван {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
