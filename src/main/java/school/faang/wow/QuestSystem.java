package school.faang.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    public static final long CONVERT_TO_SECONDS = 1000L;
    private final ExecutorService executor = Executors.newFixedThreadPool(2);


    public synchronized CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * CONVERT_TO_SECONDS);
                player.setExperience(player.getExperience() + quest.getReward());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return player;
        }, executor);
    }
}
