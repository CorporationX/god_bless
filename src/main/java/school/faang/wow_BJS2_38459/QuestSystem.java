package school.faang.wow_BJS2_38459;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        int toSecond = 1000;

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(player.getLevel() * toSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player.setExperience(player.getExperience() + quest.getReward());

            executorService.shutdown();
            return player;
        }, executorService);
    }
}
