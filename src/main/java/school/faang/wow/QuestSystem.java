package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private static final int EASY_DIFFICULTY = 5000;
    private static final int MEDIUM_DIFFICULTY = 10000;
    private static final int HARD_DIFFICULTY = 15000;
    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> questResult = CompletableFuture.supplyAsync(() -> completingQuest(player, quest), executor);
        return questResult;
    }

    private Player completingQuest(Player player, Quest quest) {
        try {
            if (quest.getDifficulty().equals("Easy")) {
                Thread.sleep(EASY_DIFFICULTY);
                player.setExperience(player.getExperience() + quest.getReward());
            }
            if (quest.getDifficulty().equals("Medium")) {
                Thread.sleep(MEDIUM_DIFFICULTY);
                player.setExperience(player.getExperience() + quest.getReward());
            }
            if (quest.getDifficulty().equals("Hard")) {
                Thread.sleep(HARD_DIFFICULTY);
                player.setExperience(player.getExperience() + quest.getReward());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("The thread was interrupted after the sleep state: ", e);
        }
        return player;
    }

    public void shutdown() {
        executor.shutdown();
    }
}
