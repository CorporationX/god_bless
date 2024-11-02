package school.faang.threadasync;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> questFuture = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(quest.getDifficulty() * 1000);
                player.addExperience(quest.getReward());
                return player;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });


        return questFuture;
    }
}
