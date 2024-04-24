package faang.school.godbless.Async.WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private final ExecutorService executor = Executors.newFixedThreadPool(2);
    public CompletableFuture<Player> startQuest(Player player, Quest quest){

        return CompletableFuture.supplyAsync(() ->
        {
            if(player.getLevel() >= quest.getDifficulty()){
                return new Player(player.getName(), player.getLevel(), player.getExperience() + quest.getReward());
            }
                return player;
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
