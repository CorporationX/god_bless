package faang.school.godbless.async.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        var playerCompletableFuture = CompletableFuture.supplyAsync(() -> player.completeQuest(quest));
        try {
            TimeUnit.SECONDS.sleep(quest.difficulty());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return playerCompletableFuture;
    }
}
