package faang.BJS2_74628;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(quest.difficulty());
                player.increaseExperience(quest.reward());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return player;
        });
    }
}


