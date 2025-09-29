package school.faang.bjs294515;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@NoArgsConstructor
public class QuestSystem {
    private Player player;
    private Quest quest;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        if (player == null || quest == null) {
            throw new IllegalArgumentException("Player and Quest must not be null");
        }

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 * quest.getDifficulty());
                player.setExperience(player.getExperience() + quest.getReward());
                System.out.println("" + player.getName() + " is completing the quest: " + quest.getName()
                        + " with difficulty: " + quest.getDifficulty() + " and reward: " + quest.getReward() + ". ");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted: " + e.getMessage());
            }
            return player;
        });
    }
}
