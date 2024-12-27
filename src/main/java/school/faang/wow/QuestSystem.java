package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public static final long DURATION_MS = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} is starting quest: {}", player.getName(), quest.name());
                Thread.sleep(quest.difficulty() * DURATION_MS);
            } catch (InterruptedException e) {
                throw new RuntimeException("Operation timed out while waiting");
            }
            player.updateExperience(quest.reward());
            return player;
        });
    }
}
