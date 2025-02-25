package school.faang.sprint4.task_63939;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> player.joinQuest(quest), executor);
    }
}
