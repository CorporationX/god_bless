package school.faang.bjs294515;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
@NoArgsConstructor
public class QuestSystem {
    private static final int MILLISECONDS_IN_SECOND = 1000;

    private Player player;
    private Quest quest;
    private ExecutorService executorService;

    public QuestSystem(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        if (player == null || quest == null) {
            throw new IllegalArgumentException("Player and Quest must not be null");
        }

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(MILLISECONDS_IN_SECOND * quest.getDifficulty());
                player.addExperience(quest.getReward());
                System.out.println(String.format("%s is completing the quest: %s with difficulty: %d and reward: %d.",
                    player.getName(), quest.getName(), quest.getDifficulty(), quest.getReward()));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted: " + e.getMessage());
            }
            return player;
        }, executorService);
    }
}
