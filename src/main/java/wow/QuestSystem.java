package wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService service = Executors.newCachedThreadPool();
        CompletableFuture<Player> playerAfterQuest = CompletableFuture.
                supplyAsync(() -> {
                    try {
                        Thread.sleep(quest.getDifficulty()*100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    player.setExperience(player.getExperience() + quest.getReward());
                    return player;
                }, service);
        service.shutdown();
        return playerAfterQuest;
    }
}
