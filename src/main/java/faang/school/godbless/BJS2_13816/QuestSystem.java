package faang.school.godbless.BJS2_13816;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    private final ExecutorService service = Executors.newFixedThreadPool(2);
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
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

    public void stopThreadsPool(){
        this.service.shutdown();
    }
}
