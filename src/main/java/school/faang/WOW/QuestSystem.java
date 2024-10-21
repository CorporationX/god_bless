package school.faang.WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Supplier<Player> completingQuest = () -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Quest interrupted " + e.getMessage(), e);
            }
            return player;
        };

        Function<Player, Player> issuingReward = (playerInstance -> {
            playerInstance.setExperience(playerInstance.getExperience() + quest.getReward());
            return playerInstance;
        });

        Function<Throwable, Player> exceptionHandler = (e -> {
            executorService.shutdownNow();
            throw new IllegalStateException("Quest interrupted " + e.getMessage(), e);
        });

        CompletableFuture<Player> future = CompletableFuture.supplyAsync(completingQuest, executorService)
                .thenApply(issuingReward)
                .exceptionally(exceptionHandler);

        executorService.shutdown();

        return future;
    }
}
