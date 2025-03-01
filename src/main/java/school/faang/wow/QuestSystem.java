package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (Exception e) {
                log.error("Выполнение квеста было прервано ошибкой {}", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            player.addExperience(quest.getDifficulty());
            return player;
        });
    }
}
