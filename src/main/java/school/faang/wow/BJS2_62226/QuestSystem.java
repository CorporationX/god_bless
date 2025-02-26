package school.faang.wow.BJS2_62226;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final Logger log = LoggerFactory.getLogger(QuestSystem.class);
    private static final int BASE_QUEST_TIME = 3000;

    public CompletableFuture<Player> startQuest(@NonNull Player player, @NonNull Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.difficulty() + BASE_QUEST_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Задача прервана {}", e.getMessage());
            }

            player.addExperience(quest.reward());
            return player;
        });
    }
}
