package school.faang.wowbjs501146;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public static final int TIME_MULTIPLIER = 1000;

    private static final Logger logger = LoggerFactory.getLogger(QuestSystem.class);

    public CompletableFuture<Player> startQuest(Player player,
                                                Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                logger.info("{}  is starting the quest: {}", player.getName(), quest.getName());
                Thread.sleep(quest.getDifficulty() * TIME_MULTIPLIER);
                player.addExperience(quest.getReward());
                logger.info("{} has completed the quest: {} and received {} experience points",
                        player.getName(), quest.getName(), quest.getReward());
            } catch (InterruptedException e) {
                logger.error("Quest interrupted for player: {}", player.getName(), e);
                throw new RuntimeException(e);
            }
            return player;
        });
    }
}
