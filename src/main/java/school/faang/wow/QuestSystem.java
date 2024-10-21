package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    public static final int EASY_DIFFICULTY = 10000;
    public static final int MEDIUM_DIFFICULTY = 20000;
    public static final int HARD_DIFFICULTY = 30000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<Player> questResult = CompletableFuture.supplyAsync(() -> completingQuest(player, quest), executor);
        executor.shutdown();
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
}
