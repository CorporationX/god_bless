package faang.school.godbless.BJS2_13816;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    private ExecutorService service;
    private CompletableFuture<Player> playerCompletableFuture;
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        this.service = Executors.newFixedThreadPool(2);
        playerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                player.upExperience(quest.getReward());
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            return player;
        }, service);
        return playerCompletableFuture;
    }

    public void stopThreadPool(ExecutorService service){
        service.shutdown();
    }

    public ExecutorService getService(){
        return service;
    }
}
