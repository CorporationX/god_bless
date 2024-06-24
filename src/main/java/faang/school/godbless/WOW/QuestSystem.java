package faang.school.godbless.WOW;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private static final int COUNT_THREAD = 2;
    @Getter
    private ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);
    public CompletableFuture<Player> startQuest(Player player, Quest quest){
        return CompletableFuture.supplyAsync(() -> player.task(quest), executorService);
    }
}
