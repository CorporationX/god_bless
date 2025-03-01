package school.faang.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("%s started quest %s%n", player.getName(), quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000L);
                player.addExperience(quest.getReward());
                System.out.printf("%s completed quest %s%n", player.getName(), quest.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Quest interrupted " + e);
            }
            return player;
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            } catch(InterruptedException e){
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
