package faang.school.godbless.BJS2_13816;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                player.upExperience(quest.getReward());
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            return player;
        }, service);
    }
}
