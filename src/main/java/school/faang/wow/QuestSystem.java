package school.faang.wow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final int TIME_FACTOR = 1000;

    private static final Logger logger = LoggerFactory.getLogger(QuestSystem.class);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                int questTime = quest.getDifficulty() * TIME_FACTOR;
                Thread.sleep(questTime);
                System.out.println("The quest difficulty time: " + questTime + "ms");
                player.addExperience(quest.getReward());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Quest was interrupted during Thread.sleep(). Player: {}, Quest: {}",
                        player.getName(), quest.getName(), e);
                throw new RuntimeException("Quest was interrupted", e);
            }
            return player;
        });
    }
}
