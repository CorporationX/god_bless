package school.faang.task_50006;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;


public class QuestSystem {
    public static final Logger LOGGER = LoggerFactory.getLogger(QuestSystem.class);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                LOGGER.debug("Ошибка выполнения потока {}", e.getMessage());
            }
            player.addExperience(quest.getReward());
            return player;
        });
    }
}
