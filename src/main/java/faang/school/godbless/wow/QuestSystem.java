package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Player> result = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(quest.getDifficulty());
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        }, executor);
        executor.shutdown();
        return result;
    }


}
