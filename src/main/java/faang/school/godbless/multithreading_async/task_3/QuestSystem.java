package faang.school.godbless.multithreading_async.task_3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {

    private static final int THREAD_COUNT = 2;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_COUNT);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> player.startQuest(quest), EXECUTOR);
    }

    public void shutdown() {
        EXECUTOR.shutdown();
    }
}
