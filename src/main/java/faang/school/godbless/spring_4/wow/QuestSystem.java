package faang.school.godbless.spring_4.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    public final ExecutorService pool = Executors.newFixedThreadPool(4);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> player, pool);
    }
}
