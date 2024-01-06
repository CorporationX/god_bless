package faang.school.godbless.wow;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws ExecutionException, InterruptedException {
        CompletableFuture<Player> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
        future.get();
        return future;
    }
}
