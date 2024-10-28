package school.faang.sprint4.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
                player.addExperience(quest.getReward());
            } catch (InterruptedException e) {
                System.out.println("Invalid thread");
            }
            return player;
        });
    }
}
