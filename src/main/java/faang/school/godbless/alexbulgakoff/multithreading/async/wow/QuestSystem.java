package faang.school.godbless.alexbulgakoff.multithreading.async.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Alexander Bulgakov
 */

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws ExecutionException, InterruptedException {

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty());
                player.setExperience(quest.getReward() + player.getExperience());
            } catch (InterruptedException e ) {
                throw new RuntimeException(e);
            }

            return player;
        });
    }

}
