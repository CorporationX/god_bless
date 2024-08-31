package wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws InterruptedException{
        CompletableFuture<Player> result = CompletableFuture.supplyAsync(() -> player);
        Thread.sleep(quest.getDifficult());
        return result;
    }
}
