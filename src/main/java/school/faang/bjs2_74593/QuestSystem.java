package school.faang.bjs2_74593;

import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class QuestSystem {
    private static final int EXP_LVLUP_THRESHHOLD = 5;
    private final ExecutorService executor = Executors.newFixedThreadPool(4);
    private final Lock lock = new ReentrantLock();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("Player %s is doing quest \"%s\" with difficulty level \"%s\"%n",
                    player.getName(), quest.getName(), quest.getDifficultyLevel());
            try {
                Thread.sleep(quest.getDifficultyLevel().getSleepTime());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Quest was interrupted", e);
            }
            return player;
        }, executor).thenApply(playerExpGain -> {
            lock.lock();
            try {
                playerExpGain.setExperience(player.getExperience() + quest.getReward());
                return playerExpGain;
            } finally {
                lock.unlock();
            }
        }).thenApply(playerLevelUp -> {
            lock.lock();
            try {
                int newLevel = playerLevelUp.getExperience() / EXP_LVLUP_THRESHHOLD;
                if (playerLevelUp.getLevel() < newLevel) {
                    playerLevelUp.setLevel(newLevel);
                    System.out.printf("Player %s leveled up! Current level = %d\n",
                            player.getName(), playerLevelUp.getLevel());
                }
                return playerLevelUp;
            } finally {
                lock.unlock();
            }
        });
    }
}



