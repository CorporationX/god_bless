package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> future = CompletableFuture.supplyAsync(() -> quest.start(quest))
                .thenApply(player::updateExperience);
        Player updatePlayer = future.join();
        return CompletableFuture.completedFuture(updatePlayer);
    }
}