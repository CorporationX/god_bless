package school.faang.task_50116;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {

    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Player> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.difficulty() * 1000);
                player.setExperience(player.getExperience() + 1);
                return player;
            } catch (InterruptedException e) {
                log.error("Ошибка выполнения квеста" + e);
                return null;
            }
        }, executorService);
        completableFuture.whenComplete((result, throwable) -> {
            executorService.shutdown();
        });
        return completableFuture;
    }

}
