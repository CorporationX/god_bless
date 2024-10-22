package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private static final int EASY_DIFFICULTY = 1500;
    private static final int MEDIUM_DIFFICULTY = 2000;
    private static final int HARD_DIFFICULTY = 3000;
    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public CompletableFuture<Void> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> completingQuest(player, quest), executor)
                .thenAccept(player1 -> System.out.println("Player " + player1.getName()
                        + " completed the quest and earned " + player1.getExperience() + " points"));
    }

    private Player completingQuest(Player player, Quest quest) {
        try {
            if (quest.getDifficulty().equals("Easy")) {
                Thread.sleep(EASY_DIFFICULTY);
                player.addExperience(quest.getReward());
            }
            if (quest.getDifficulty().equals("Medium")) {
                Thread.sleep(MEDIUM_DIFFICULTY);
                player.addExperience(quest.getReward());
            }
            if (quest.getDifficulty().equals("Hard")) {
                Thread.sleep(HARD_DIFFICULTY);
                player.addExperience(quest.getReward());
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
