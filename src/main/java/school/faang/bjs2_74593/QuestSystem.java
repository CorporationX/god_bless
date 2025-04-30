package school.faang.bjs2_74593;

import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class QuestSystem {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("Player %s is doing quest \"%s\" with difficulty level \"%s\"%n",
                    player.getName(), quest.getName(), quest.getDifficultyLevel());
            try {
                switch (quest.getDifficultyLevel()) {
                    case EASY -> Thread.sleep(2000);
                    case NORMAL -> Thread.sleep(3000);
                    case HEROIC -> Thread.sleep(5000);
                    case MYTHIC -> Thread.sleep(10000);
                    default -> Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Quest was interrupted", e);
            }
            return player;
        }, executor).thenApply(playerExpGain -> {
            playerExpGain.setExperience(playerExpGain.getExperience() + quest.getReward());
            return playerExpGain;
        }).thenApply(playerLevelUp -> {
            int newLevel = playerLevelUp.getExperience() / 5;
            if (playerLevelUp.getLevel() < newLevel) {
                playerLevelUp.setLevel(newLevel);
                System.out.printf("Player %s leveled up! Current level = %d\n",
                        player.getName(), playerLevelUp.getLevel());
            }
            return playerLevelUp;
        });
    }
}



