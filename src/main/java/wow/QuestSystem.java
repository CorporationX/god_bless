package wow;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final Logger logger = LoggerFactory.getLogger(QuestSystem.class);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> executeQuest(player, quest));
    }

    private Player executeQuest(Player player, Quest quest) {
        try {
            logger.info("{} начал выполнение квеста '{}'", player.getName(), quest.getName());

            Thread.sleep(quest.getDifficulty() * 1000L);

            player.setExperience(player.getExperience() + quest.getReward());

            logger.info("ExecuteQuest: {} завершил квест '{}' и получил {} опыта", player.getName(), quest.getName(), quest.getReward());

            return player;
        } catch (InterruptedException e) {
            logger.error("Квест '{}' был прерван для игрока {}", quest.getName(), player.getName(), e);
            throw new RuntimeException(e);
        }
    }
}
